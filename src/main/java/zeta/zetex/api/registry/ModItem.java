package zeta.zetex.api.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static zeta.zetex.ZetEX.MOD_ID;

public class ModItem extends zeta.zetex.api.registry.Registry {
    Item item;
    public ModItem(String id, ItemGroup creativeTab) {
        super(id);
        id = id.toLowerCase();
        this.item = new Item(new FabricItemSettings().group(creativeTab));
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, id), this.item);
    }

}
