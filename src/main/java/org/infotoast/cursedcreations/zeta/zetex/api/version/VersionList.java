package org.infotoast.cursedcreations.zeta.zetex.api.version;

public class VersionList {
    public static Version THE_FRINGELANDS_UPDATE = new Version("1.1");


    public record Version(String version) {
        public String versionName() {
            return VersionNames.values()[VersionNames.getOrdinal(version)].toString();
        }
        @Override
        public String toString() {
            return VersionNames.values()[VersionNames.getOrdinal(version)].toString() + " - " + version;
        }
    }
}
