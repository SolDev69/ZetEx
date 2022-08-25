package zeta.zetex.registry;

import net.minecraft.item.ItemGroup;
import zeta.zetex.api.registry.ModItem;
import zeta.zetex.api.registry.Registry;
import zeta.zetex.api.util.NotStaticException;

public class ItemAndBlockRegistry {
    public static ModItem TOKEN;
    public ItemAndBlockRegistry() throws NotStaticException {
        throw new NotStaticException("No constructor needed!");
    }
    public static void register() {
        TOKEN = new ModItem("TOKEN", ItemGroup.MISC);
    }
    public static boolean isRegistered(Registry object) {
        return object != null;
    }
}
