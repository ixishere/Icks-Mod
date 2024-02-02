package me.ix.icksmod.gui.client;

import java.io.IOException;

import me.ix.icksmod.utils.Bungie;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GuiConfig extends GuiScreen {
	
	final ResourceLocation texture = new ResourceLocation(Bungie.MOD_ID, "textures/gui/config/configBackground.jpg");
	int guiHeight = 256;
	int guiWidth = 256;
	
	int baseWidth = 0;
	int baseHeight = 5;
	
	public GuiConfig() {
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		//drawTexturedModalRect(0, 0, 0, 0, guiWidth, guiHeight);
		this.drawDefaultBackground();
		
		mc.fontRenderer.drawStringWithShadow("Icks Mod - Config Menu", this.width/2 - (mc.fontRenderer.getStringWidth("Icks Mod - Config Menu")/2), baseHeight, 0xFF0083);
		
		mc.fontRenderer.drawStringWithShadow("Cosmetics", this.width/2 - (mc.fontRenderer.getStringWidth("Cosmetics")/2), baseHeight + 50, 0x00FFC1);
		mc.fontRenderer.drawStringWithShadow("Wings:", this.width/3 + 20, baseHeight + 50 + 30, 0x42FF00);
		mc.fontRenderer.drawStringWithShadow("Cape:", this.width/3 + 20, baseHeight + 50 + 30 + 30, 0x42FF00);
		
		mc.fontRenderer.drawStringWithShadow("Keybinds", this.width/2 - (mc.fontRenderer.getStringWidth("Keybinds")/2), baseHeight + 50 + 30 + 30 + 50, 0x00FFC1);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(0, this.width/3 + 60, baseHeight + 50 + 22, 98, 20, I18n.format("Black Angel Wings")));
		this.buttonList.add(new GuiButton(0, this.width/3 + 160, baseHeight + 50 + 22, 98, 20, I18n.format("White Angel Wings")));
		
		this.buttonList.add(new GuiButton(0, this.width/3 + 60, baseHeight + 50 + 30 + 22, 98, 20, I18n.format("Enabled: OFF")));
		this.buttonList.add(new GuiButton(0, this.width/3 + 160, baseHeight + 50 + 30 + 22, 98, 20, I18n.format("Cape Editor")));
	
		super.initGui();
	}
	
	@Override
	public void onGuiClosed() {
		
	}
}
