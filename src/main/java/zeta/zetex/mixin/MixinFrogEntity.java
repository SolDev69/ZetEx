package zeta.zetex.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.tag.EntityTypeTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import zeta.zetex.api.managers.GeneralManager;

@Mixin(FrogEntity.class)
public class MixinFrogEntity {
    /**
     * @author
     * @reason
     */
    @Overwrite
    public static boolean isValidFrogFood(LivingEntity entity) {
        if (entity instanceof SlimeEntity slimeEntity) {
            if (slimeEntity.getSize() != 1) {
                return false;
            }
        }
        return entity.getType().isIn(EntityTypeTags.FROG_FOOD) || GeneralManager.getConfig().validFrogFood.getValue().contains(entity.getEntityName());
    }
}
