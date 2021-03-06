package zeta.zetex.api;

public final class Helper {
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


    public static class ArrayHelper {
        public static void insertAtPositionInline(int[] array, int num, int position) {
            int i;
            for (i = array.length-1; i > position; i--)
                array[i] = array[i-1];

            array[i]=  num;
        }
        public static int[] insertAtPosition(int[] array, int num, int position) {
            int i;
            for(i = array.length-1; i > position; i--)
                array[i] = array[i-1];
            array[i]=num;
            return array;
        }

    }
}
