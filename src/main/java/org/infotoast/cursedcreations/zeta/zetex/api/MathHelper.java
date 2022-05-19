package org.infotoast.cursedcreations.zeta.zetex.api;

public final class MathHelper {
    public static long farlandsCalc(int input) {
        return floorDiv(input, 171.103d);
    }
    public static long farlandsCalc(int input, int scale) {
        return floorDiv(input * scale, 171.103d);
    }

    public static long floorDiv(double in1, double in2) {
        return (long) Math.floor(in1 / in2);
    }

    public static int randInt(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min); //The maximum is inclusive and the minimum is inclusive
    }
}
