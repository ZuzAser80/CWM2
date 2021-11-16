package net.zuz.cwm.items.trinkets.PocketShulker;

public class PocketShulkerC2SPacket {
    //public static final Identifier ID = new Identifier("cwm", "shulk_open");
    //    public static TrinketItem Bonk = BonkItem.item;
    //    public static KeyBinding drinkBonk;
    //    public static final int cooldown = 400;
    //
    //
    //    public static void onPacket(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buffer, PacketSender sender) {
    //        server.execute(() -> {
    //            if (TrinketsApi.getTrinketComponent(player).get().isEquipped(Bonk) && !player.getItemCooldownManager().isCoolingDown(Bonk)) {
    //                player.getItemCooldownManager().set(Bonk, cooldown);
    //                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 180, 9, true, false));
    //                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 180, 9, true, false));
    //                player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 180, 9, true, false));
    //                System.out.println("U are drunk now!");
    //            } else {
    //                System.out.println("bloody hasting scouts");
    //            }
    //        });
    //    }
    //    public static void Keybind()
    //    {
    //
    //        drinkBonk = KeyBindingHelper.registerKeyBinding(new KeyBinding(
    //                "key.cwm.drinkbonk",
    //                InputUtil.Type.KEYSYM,
    //                GLFW.GLFW_KEY_G,
    //                "cwm.main.main"
    //        ));
    //        ClientTickEvents.END_CLIENT_TICK.register(client -> {
    //            while (drinkBonk.wasPressed()) {
    //                if (TrinketsApi.getTrinketComponent(client.player).get().isEquipped(BonkItem.item)) {
    //                    client.getNetworkHandler().sendPacket(BonkC2SPacket.create());
    //                }
    //            }
    //        });
    //    }
    //    public static Packet<?> create() {
    //        PacketByteBuf buffer = new PacketByteBuf(Unpooled.buffer());
    //        return ClientPlayNetworking.createC2SPacket(ID, buffer);
    //    }
}
