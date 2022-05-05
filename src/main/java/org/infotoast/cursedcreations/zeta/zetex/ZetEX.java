package org.infotoast.cursedcreations.zeta.zetex;

import me.zeroeightsix.fiber.exception.FiberException;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.SharedConstants;
import org.apache.commons.logging.Log;
import org.infotoast.cursedcreations.zeta.zetex.managers.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class ZetEX implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "zetex";
	public static final String MOD_NAME = "ZetEX";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
	public static String MOD_VERSION;

	public static void setModVersion() {
		String modVersionImpl = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().toString();
		String modDataVersion = modVersionImpl.split("-")[0];
		Double modData = Double.parseDouble(modVersionImpl.split("\\.")[1]);
		if (Boolean.TRUE.equals(ConfigManager.getConfig().useClassicVersionString.getValue())) modDataVersion = "v"+modVersionImpl.split("-")[0];

		if (Boolean.TRUE.equals(ConfigManager.getConfig().useClassicVersionString.getValue()) && !modDataVersion.split("\\.")[1].contains("0")) {
			modDataVersion += ".0";
		}
		if (modVersionImpl.contains("prerelease")) {
			MOD_VERSION =  modDataVersion + " Pre-release " + modVersionImpl.split("\\.")[modVersionImpl.split("\\.").length-1];
		} else if(modVersionImpl.contains("rc")) {
			MOD_VERSION = modDataVersion + " Release Candidate " + modVersionImpl.split("\\.")[modVersionImpl.split("\\.").length-1];
		}
		else {
			MOD_VERSION = modVersionImpl;
		}
		if (getModVersion().endsWith("-")) MOD_VERSION = MOD_VERSION.split("-")[0];
		// TODO : Autodetect mod version is in format 1.x and display update name accordingly ("Enum constant ordinal")
		if (modVersionImpl.equals("1.1") || modVersionImpl.equals("v1.1.0")) MOD_VERSION += " - The Fringe Lands Update";
	}


	public static boolean isDevVersion() {
		return Boolean.TRUE.equals(ConfigManager.getConfig().isDevVersion.getValue());
	}

	public static String getModVersion() {
		return FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().toString();
	}
	public static String ZFVersionString;

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		if (!(Objects.equals(getModVersion(), "development-version")))
		{ setModVersion(); } else {
			MOD_VERSION = getModVersion();
		}
		ZFVersionString = "ZetEX " + ZetEX.MOD_VERSION;
		LOGGER.info("Hello Fabric world!");
		LOGGER.info("Initializing config");
		LOGGER.info("Loading on minecraft version " + SharedConstants.getGameVersion().getName());
		try {
			ConfigManager.initialize();
		} catch (FiberException e) {
			LOGGER.error("Loading failed!");
			e.printStackTrace();
		}
	}
}
