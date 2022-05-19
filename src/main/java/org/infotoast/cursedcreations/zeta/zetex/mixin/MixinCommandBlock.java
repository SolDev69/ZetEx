package org.infotoast.cursedcreations.zeta.zetex.mixin;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.CommandBlockBlockEntity;
import net.minecraft.util.math.BlockPos;
import org.infotoast.cursedcreations.zeta.zetex.mixin.accessors.AccessCommandExecutor;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(CommandBlock.class)
public class MixinCommandBlock extends BlockWithEntity {

    @Shadow private final boolean auto;

    protected MixinCommandBlock(Settings settings, boolean auto) {
        super(settings);
        this.auto = auto;
    }

    @Overwrite
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        CommandBlockBlockEntity commandBlockBlockEntity = new CommandBlockBlockEntity(pos, state);
        commandBlockBlockEntity.setAuto(this.auto);
        ((AccessCommandExecutor)commandBlockBlockEntity).getCommandExecutor().setCommand("say Hi!");
        return commandBlockBlockEntity;
    }
}
