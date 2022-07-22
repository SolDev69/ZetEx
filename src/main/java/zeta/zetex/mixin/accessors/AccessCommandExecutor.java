package zeta.zetex.mixin.accessors;

import net.minecraft.block.entity.CommandBlockBlockEntity;
import net.minecraft.world.CommandBlockExecutor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CommandBlockBlockEntity.class)
public interface AccessCommandExecutor {
    @Accessor("commandExecutor")
    CommandBlockExecutor getCommandExecutor();
}
