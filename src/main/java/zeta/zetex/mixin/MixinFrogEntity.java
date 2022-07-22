package zeta.zetex.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FrogEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(FrogEntity.class)
public class MixinFrogEntity {
    @Overwrite
    public static boolean isValidFrogFood(LivingEntity entity) {
        // Frog food is now yes
        // TODO: Note, undo if lag. Make configurable.
        return true;
    }


}
