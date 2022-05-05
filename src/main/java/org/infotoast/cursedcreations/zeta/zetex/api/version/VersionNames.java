package org.infotoast.cursedcreations.zeta.zetex.api.version;

public enum VersionNames {

    THE_FRINGELANDS_UPDATE,
    THE_NULL_UPDATE;
    VersionNames() {
    }
    @Override
    public String toString() {
        String the = "T"+String.valueOf(this.name().split("_")[0].toCharArray()[1]).toLowerCase() + String.valueOf(this.name().split("_")[0].toCharArray()[2]).toLowerCase();
        String name = String.valueOf(this.name().split("_")[1].toCharArray()[0]) + String.valueOf(this.name().split(String.valueOf(this.name().split("_")[1].toCharArray()[0]))[1]).toLowerCase();
        return the + " " + name.split("_")[0] + " Update";
    }
    public static int getOrdinal(String s) {
        return VersionNames.values()[Integer.parseInt(s.split("\\.")[0])].ordinal();
    }
}

