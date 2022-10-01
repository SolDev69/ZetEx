package zeta.zetex.api.managers;

import me.zeroeightsix.fiber.JanksonSettings;
import me.zeroeightsix.fiber.exception.FiberException;
import me.zeroeightsix.fiber.tree.ConfigNode;
import me.zeroeightsix.fiber.tree.ConfigValue;
import me.zeroeightsix.fiber.tree.Node;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.tag.EntityTypeTags;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.A;
import zeta.zetex.ZetEX;

import java.io.*;
import java.nio.file.Files;
import java.security.PrivilegedAction;
import java.util.ArrayList;


public class ConfigManager  {
    /*
     * Copied from https://github.com/geniiii/FarLands/blob/master/src/main/java/site/geni/farlands/config/Config.java
     */
    public static final File CONFIG_FILE = new File(FabricLoader.getInstance().getConfigDirectory(),
             "zetex." +
                    "json5"
    );

    final private ConfigNode root = new ConfigNode();

    private final Node general = root.fork("General");
    private final Node world = root.fork("World");
    private final Node gameplay = root.fork("Gameplay");
    private final Node doodleAPI = root.fork("Title Screen writer");
    public ConfigValue<String> doodleAPIMessage = ConfigValue.builder(String.class)
            .withName("Message")
            .withDefaultValue("")
            .withParent(doodleAPI)
            .build();
    public ConfigValue<Integer> doodleAPIXPos = ConfigValue.builder(Integer.class)
            .withName("X")
            .withDefaultValue(1)
            .withParent(doodleAPI)
            .build();
    public ConfigValue<Boolean> showDoodle = ConfigValue.builder(Boolean.class)
            .withName("Show or Hide")
            .withComment("true = show \n false = hide")
            .withDefaultValue(true)
            .build();
    public ConfigValue<Integer> doodleAPIYPos = ConfigValue.builder(Integer.class)
            .withName("Y")
            .withDefaultValue(1)
            .withParent(doodleAPI)
            .build();
    public ConfigValue<Integer> doodleAPIColor = ConfigValue.builder(Integer.class)
            .withName("Color")
            .withDefaultValue(16777215)
            .withParent(doodleAPI)
            .build();

    // Still @Overwrite-able!

    public ConfigValue<Boolean> useClassicVersionString = ConfigValue.builder(Boolean.class)
            .withName("useClassicVersionString")
            .withComment("This will add back the \"v\" before the version number and the extra 0 at the end if no minor version is found")
            .withDefaultValue(false)
            .withParent(general)
            .build();
    public ConfigValue<Boolean> isDevVersion = ConfigValue.builder(Boolean.class)
            .withName("isDev")
            .withComment("Will force enable /dev flags")
            .withDefaultValue(ZetEX.getModVersion().contains("-") || FabricLoader.getInstance().isDevelopmentEnvironment())
            .withParent(general)
            .build();
    public ConfigValue<Integer> fireballCap = ConfigValue.builder(Integer.class)
            .withName("fireballCap")
            .withComment("Maximum strength a fireball can be set.")
            .withDefaultValue(100)
            .withParent(gameplay)
            .build();
    public ConfigValue<Boolean> fixFireballs = ConfigValue.builder(Boolean.class)
            .withName("capFireballs")
            .withComment("If set to true, removes the patch done " +
                    "to fix " +
                    "https://bugs.mojang.com/browse/MC-220698" +
                    "and makes bedrock farms work again")
            .withDefaultValue(true)
            .withParent(gameplay)
            .build();
    ArrayList<String> vFFd = new ArrayList<>();
    {
        vFFd.add("Goat");
    }
    public ConfigValue<ArrayList> validFrogFood = ConfigValue.builder(ArrayList.class)
            .withName("Valid Frog Food")
            .withComment("List of entities that are considered valid frog food")
            .withDefaultValue(vFFd)
            .withParent(gameplay)
            .build();

    public static ConfigManager getConfig() {
        return GeneralManager.CONFIG;
    }
    /*
    private ConfigManager() throws FiberException, IOException {
        File currentConfigFile = new File(FabricLoader.getInstance().getGameDir().toFile(),
                CONFIG_FILE.getName() + ".tmp");
        currentConfigFile.createNewFile();
        save(currentConfigFile);
        File configFile = new File(FabricLoader.getInstance().getConfigDirectory(),
                CONFIG_FILE.getName() + ".tmp");
        configFile.createNewFile();
        //if(CONFIG_FILE.exists()) {
        //    if(currentConfigFile.hashCode() != CONFIG_FILE.hashCode()) {

        //    } else {
        //        LogManager.getLogger().log(Level.INFO, "Will not delete config file!");
        //    }
        //}
        if((!configFile.exists()) && CONFIG_FILE.exists()) {
            try {
                copy(CONFIG_FILE, configFile);
            } catch (NoSuchFileException e) {
                e.printStackTrace();
                throw e;
            }
        }
        if(!HelperUtilities.hash(configFile).equals(HelperUtilities.hash(currentConfigFile))) {
            logger.error("CONFIG FOUND WITH DIFFERENT HASH, DELETING!");
            CONFIG_FILE.delete();
             //configFile.delete();
        }
         //currentConfigFile.delete();
    }
     */
    public ConfigManager() throws FiberException {}


    private Logger logger = LogManager.getLogger();

    public static ConfigManager initialize() throws FiberException {
        return new ConfigManager();
    }

    public void save() {
        try {
            new JanksonSettings().serialize(this.root, Files.newOutputStream(CONFIG_FILE.toPath()), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConfigManager load() {
        if (!CONFIG_FILE.exists()) {
            this.save();
        }

        try {
            new JanksonSettings().deserialize(this.root, Files.newInputStream(CONFIG_FILE.toPath()));
        } catch (IOException | FiberException e) {
            e.printStackTrace();
        }
        return this;
    }
}
