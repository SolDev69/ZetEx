package org.infotoast.cursedcreations.zeta.zetex.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tag.EntityTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import static org.infotoast.cursedcreations.zeta.zetex.api.MathHelper.randInt;

@Mixin(FrogEntity.class)
public class MixinFrogEntity {
    @Overwrite
    public static boolean isValidFrogFood(LivingEntity entity) {
        // Frog food is now yes
        // TODO: Note, undo if lag. Make configurable.
        return true;
    }


}
