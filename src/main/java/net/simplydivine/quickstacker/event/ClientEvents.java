package net.simplydivine.quickstacker.event;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.simplydivine.quickstacker.QuickStacker;
import net.minecraftforge.api.distmarker.Dist;
import net.simplydivine.quickstacker.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = QuickStacker.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.quickStackKey);
        }

        @SubscribeEvent
        public static void onKeyInput(InputEvent event) {
            if (KeyBinding.quickStackKey.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a key"));
            }
        }
    }
}
