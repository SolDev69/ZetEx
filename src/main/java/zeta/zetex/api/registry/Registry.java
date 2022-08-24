package zeta.zetex.api.registry;

import java.util.HashMap;

public abstract class Registry {
    public final String ID;
    public static final HashMap<Registry, String> REGISTERED = new HashMap<>();
    public static final HashMap<ModBlock, String> REGISTERED_BLOCKS = new HashMap<>();
    public static final HashMap<ModItem, String> REGISTERED_ITEMS = new HashMap<>();
    Registry(String id) {
        this.ID = id;
        REGISTERED.put(this, ID);
        if (this instanceof ModBlock) REGISTERED_BLOCKS.put((ModBlock) this, ID);
        if (this instanceof ModItem) REGISTERED_ITEMS.put((ModItem) this, ID);
    }
}
