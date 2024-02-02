package me.ix.icksmod.utils.handlers;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeybindHandler {

    public static KeyBinding menuCosmetic;
    
    public static void registerKeybinds()
    {
    	menuCosmetic = new KeyBinding("key.cosmetics", Keyboard.KEY_N, "key.categories.icksmod");
        ClientRegistry.registerKeyBinding(menuCosmetic);
    }
	
}
