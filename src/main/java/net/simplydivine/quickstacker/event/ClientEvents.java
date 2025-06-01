package net.simplydivine.quickstacker.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
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

    private QuickStackerService quickStackerService;
    private BlockPos playerPosition;
    private LocalPlayer player;
    private Level level;
    int radius = 20;

    public ClientEvents() {
        quickStackerService = new QuickStackerService();
        player = Minecraft.getInstance().player;
        level = player.level();
    }

    @Mod.EventBusSubscriber(modid = QuickStacker.MODID, value = Dist.CLIENT)
    public class ClientForgeEvents {
        @SubscribeEvent
        public void onKeyInput(InputEvent event) {
            if (KeyBinding.quickStackKey.consumeClick()) {
                var nearbyChests = quickStackerService.getNearbyChests(level, playerPosition, radius);
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a key"));
            }
        }
    }

    @Mod.EventBusSubscriber(modid = QuickStacker.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.quickStackKey);
        }
    }
}
