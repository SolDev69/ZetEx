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
        if (entity instanceof SlimeEntity slimeEntity) {
            if (slimeEntity.getSize() != 1) {
                return false;
            }
        }

        if (entity instanceof GoatEntity goatEntity) {
            return true;
        }
        if (entity instanceof PlayerEntity playerEntity) {
            return true;
        }

        return entity.getType().isIn(EntityTypeTags.FROG_FOOD);
    }


}
