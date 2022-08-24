package zeta.zetex.api.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static zeta.zetex.ZetEX.MOD_ID;

public class ModBlock extends zeta.zetex.api.registry.Registry {
    Block block;
    BlockItem blockItem;
    public ModBlock(Block block, String id, ItemGroup creativeTab) {
        super(id);
        id = id.toLowerCase();
        this.block = block;
        this.blockItem = new BlockItem(this.block, new FabricItemSettings().group(creativeTab));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, id), this.block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, id), this.blockItem);
    }

    public Block getBlock() {
        return block;
    }

    public BlockItem getBlockItem() {
        return blockItem;
    }

}
