package org.infotoast.cursedcreations.zeta.zetex.api.mixin.accessors;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(EnvType.CLIENT)
@Mixin(Screen.class)
public interface TextRendererAccessor  {
    @Accessor("textRenderer")
    TextRenderer getTextRenderer();

}
