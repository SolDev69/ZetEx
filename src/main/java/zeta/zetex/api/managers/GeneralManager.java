package zeta.zetex.api.managers;
import me.zeroeightsix.fiber.exception.FiberException;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.math.MathHelper;
import zeta.zetex.ZetEX;

public class GeneralManager implements ModInitializer {
    public static ConfigManager CONFIG;

    static {
        try {
            CONFIG = new ConfigManager().load();
        } catch (FiberException e) {
            e.printStackTrace();
        }
    }
    public static ConfigManager getConfig() {
        return CONFIG;
    }

    public static void saveConfig() {
        CONFIG.save();
    }


    @Override
    public void onInitialize() {}

}
