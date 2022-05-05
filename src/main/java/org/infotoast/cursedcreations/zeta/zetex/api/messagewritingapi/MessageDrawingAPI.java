package org.infotoast.cursedcreations.zeta.zetex.api.messagewritingapi;

import org.infotoast.cursedcreations.zeta.zetex.managers.ConfigManager;

public class MessageDrawingAPI {
    static ConfigManager config = ConfigManager.getConfig();

    public static String message = config.doodleAPIMessage.getValue();
    public static int x = config.doodleAPIXPos.getValue();
    public static int y = config.doodleAPIYPos.getValue();
    public static int color = config.doodleAPIColor.getValue();
    public static boolean showMessage = config.showDoodle.getValue();
}
