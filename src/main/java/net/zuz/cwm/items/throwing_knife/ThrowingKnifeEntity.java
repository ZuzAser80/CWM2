package net.zuz.cwm.items.throwing_knife;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ThrowingKnifeEntity extends PersistentProjectileEntity {
    private static final TrackedData<Byte> LOYALTY;
    private static final TrackedData<Boolean> ENCHANTED;
    private ItemStack anchorStack;
    private boolean dealtDamage;
    public int returnTimer;

    public ThrowingKnifeEntity(EntityType<? extends ThrowingKnifeEntity> entityType, World world, ThrowingKnifeItem item) {
        super(entityType, world);
        this.anchorStack = new ItemStack(item);
    }

    public ThrowingKnifeEntity(World world, LivingEntity owner, ThrowingKnifeItem item, ItemStack stack) {
        super(item.getType(), owner, world);
        this.anchorStack = new ItemStack(item);
        this.anchorStack = stack.copy();
        this.dataTracker.set(ENCHANTED, stack.hasGlint());
        this.dataTracker.set(LOYALTY, (byte) EnchantmentHelper.getLoyalty(stack));
    }

    @Environment(EnvType.CLIENT)
    public ThrowingKnifeEntity(World world, double x, double y, double z, ThrowingKnifeItem item) {
        super(item.getType(), x, y, z, world);
        this.anchorStack = new ItemStack(item);
    }


    @Override
    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getOwner();
        if ((this.dealtDamage || this.isNoClip()) && entity != null) {
            int i = (Byte) this.dataTracker.get(LOYALTY);
            if (i > 0 && !this.isOwnerAlive()) {
                if (!this.world.isClient && this.pickupType == PersistentProjectileEntity.PickupPermission.ALLOWED) {
                    this.dropStack(this.asItemStack(), 0.1F);
                }

                this.discard();
            } else if (i > 0) {
                this.setNoClip(true);
                Vec3d vec3d = new Vec3d(entity.getX() - this.getX(), entity.getEyeY() - this.getY(), entity.getZ() - this.getZ());
                this.setPos(this.getX(), this.getY() + vec3d.y * 0.015D * (double) i, this.getZ());
                if (this.world.isClient) {
                    this.lastRenderY = this.getY();
                }

                double d = 0.05D * (double) i;
                this.setVelocity(this.getVelocity().multiply(0.95D).add(vec3d.normalize().multiply(d)));
                if (this.returnTimer == 0) {
                    this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.returnTimer;
            }
        }

        super.tick();
    }
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        float f = 8.0F;
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            f += EnchantmentHelper.getAttackDamage(this.anchorStack, livingEntity.getGroup());
        }

        Entity entity2 = this.getOwner();
        DamageSource damageSource = DamageSource.trident(this, (Entity)(entity2 == null ? this : entity2));
        this.dealtDamage = true;
        SoundEvent soundEvent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entity.damage(damageSource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity2 = (LivingEntity)entity;
                if (entity2 instanceof LivingEntity) {
                    EnchantmentHelper.onUserDamaged(livingEntity2, entity2);
                    EnchantmentHelper.onTargetDamaged((LivingEntity)entity2, livingEntity2);
                }

                this.onHit(livingEntity2);
            }
        }
        this.setVelocity(this.getVelocity().multiply(-0.01D, -0.1D, -0.01D));
    }
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(LOYALTY, (byte)0);
        this.dataTracker.startTracking(ENCHANTED, false);
    }
    private boolean isOwnerAlive() {
        Entity entity = this.getOwner();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayerEntity) || !entity.isSpectator();
        } else {
            return false;
        }
    }

    protected ItemStack asItemStack() {
        return this.anchorStack.copy();
    }

    public boolean isEnchanted() {
        return (Boolean)this.dataTracker.get(ENCHANTED);
    }

    public boolean shouldRender(double cameraX, double cameraY, double cameraZ) {
        return true;
    }


    static {
        LOYALTY = DataTracker.registerData(TridentEntity.class, TrackedDataHandlerRegistry.BYTE);
        ENCHANTED = DataTracker.registerData(TridentEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    }
}
