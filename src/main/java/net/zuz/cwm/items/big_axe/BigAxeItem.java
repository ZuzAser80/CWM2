package net.zuz.cwm.items.big_axe;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

import java.util.UUID;

public class BigAxeItem extends SwordItem {

    public static final UUID INCREASE_UUID = UUID.fromString("7b0363d1-7818-44cc-a605-b2847a065548");

    public BigAxeItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Item.Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        Multimap<EntityAttribute, EntityAttributeModifier> modifiers = super.getAttributeModifiers(slot);
        builder.putAll(modifiers);

        if (slot == EquipmentSlot.MAINHAND) {
            builder.put(ReachEntityAttributes.REACH, new EntityAttributeModifier(INCREASE_UUID, "Glaive reach increase", 3f, EntityAttributeModifier.Operation.ADDITION));
            builder.put(ReachEntityAttributes.ATTACK_RANGE, new EntityAttributeModifier(INCREASE_UUID, "Glaive reach increase", 2f, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(INCREASE_UUID, "Glaive speed increase", -2f, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, new EntityAttributeModifier(INCREASE_UUID, "Glaive speed increase", 2f, EntityAttributeModifier.Operation.ADDITION));
        }

        return builder.build();

    }
}
