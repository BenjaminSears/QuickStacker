package net.simplydivine.quickstacker.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.simplydivine.quickstacker.QuickStacker;
import net.minecraftforge.api.distmarker.Dist;
import net.simplydivine.quickstacker.services.QuickStackerService;
import net.simplydivine.quickstacker.util.KeyBinding;

public class ClientEvents {

    private static QuickStackerService quickStackerService = new QuickStackerService();
    private static BlockPos playerPosition;
    private static LocalPlayer player;
    private static Level level;
    private static int radius = 10;

    @Mod.EventBusSubscriber(modid = QuickStacker.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent event) {
            if (KeyBinding.quickStackKey.consumeClick()) {
                player = Minecraft.getInstance().player;
                level = player.level();
                playerPosition = player.blockPosition();
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a , player position:" + playerPosition));
                var nearbyContainers = quickStackerService.GetNearbyContainers(level, playerPosition, radius, false);
                quickStackerService.FindMatchingItems(player, nearbyContainers);
            }
        }
    }

    @Mod.EventBusSubscriber(modid = QuickStacker.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.quickStackKey);
        }
    }
}
