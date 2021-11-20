package net.zuz.cwm.items.trinkets.Bonk;

import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.TrinketsApi;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

import static net.zuz.cwm.util.Helper.id;


public class BonkC2SPacket {
    public static final Identifier ID = id("bonk_keybind");
    public static TrinketItem Bonk = BonkItem.item;
    public static KeyBinding drinkBonk;


    public static void onPacket(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
        server.execute(() -> {
            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Bonk) && !player.getItemCooldownManager().isCoolingDown(Bonk)) {
                player.getItemCooldownManager().set(Bonk, 400);
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 180, 9, true, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 180, 9, true, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 180, 9, true, false));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 180, 9, true, false));
                System.out.println("U are drunk now!");
            } else {
                System.out.println("bloody hasting scouts");
            }
        });
    }
    public static void Keybind()
    {

        drinkBonk = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.cwm.drinkbonk",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                "cwm.main.main"
        ));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (drinkBonk.wasPressed()) {
                if (TrinketsApi.getTrinketComponent(client.player).get().isEquipped(Bonk)) {
                    client.getNetworkHandler().sendPacket(BonkC2SPacket.create());
                }
            }
        });
    }
    public static Packet<?> create() {
        PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
        return ClientPlayNetworking.createC2SPacket(ID, buffer);
    }
}
