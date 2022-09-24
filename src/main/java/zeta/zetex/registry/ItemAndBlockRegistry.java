package zeta.zetex.registry;

import net.minecraft.item.ItemGroup;
import zeta.zetex.api.registry.ModItem;
import zeta.zetex.api.registry.Registry;
import zeta.zetex.api.util.NotStaticException;

public class ItemAndBlockRegistry {

    
    public ItemAndBlockRegistry() throws NotStaticException {
        throw new NotStaticException("No constructor needed!");
    }
    /**
      * @Inject into the top of this method to register shit on ZetEX
      */
    public static void register() {
        
    }
    public static boolean isRegistered(Registry object) {
        return object != null;
    }
}