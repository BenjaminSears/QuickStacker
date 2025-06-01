package net.simplydivine.quickstacker.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
    public static final String QuickStackKeyCategory = "key.category.quickstacker";
    public static final String QuickStackKeyDescription = "key.quickstacker.quickstack";

    public static final KeyMapping quickStack = new KeyMapping(
            QuickStackKeyDescription,
            KeyConflictContext.IN_GAME,
            KeyModifier.CONTROL,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_S,
            QuickStackKeyCategory
    );
}
