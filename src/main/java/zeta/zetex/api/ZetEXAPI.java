package zeta.zetex.api;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZetEXAPI implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("ZetEX API");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("API initialized!");
		//LOGGER.info(VersionList.THE_FRINGELANDS_UPDATE.versionName());
	}
//	public Identifier ZMI(String name) {
//		return new Identifier(ZetEX.MOD_ID, name);
//	}

}
