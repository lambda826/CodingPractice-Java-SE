package containers.array;

import generics._109_Generator;

public class _128_CountingGenerator {

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Boolean implements _109_Generator<java.lang.Boolean> {
        private boolean value = false;

        public java.lang.Boolean next() {
            return !value;
        }
    }

    public static class Byte implements _109_Generator<java.lang.Byte> {
        private byte value = 0;

        public java.lang.Byte next() {
            return value++;
        }
    }

    public static class Character implements _109_Generator<java.lang.Character> {
        int index = -1;

        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }
    }

    public static class String implements _109_Generator<java.lang.String> {

        private int length = 7;
        _109_Generator<java.lang.Character> cg = new Character();

        public String() {
        }

        public String(int length) {
            this.length = length;
        }

        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++) {
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class Short implements _109_Generator<java.lang.Short> {
        private short value = 0;

        public java.lang.Short next() {
            return value++;
        }
    }

    public static class Integer implements _109_Generator<java.lang.Integer> {
        private int value = 0;

        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class Long implements _109_Generator<java.lang.Long> {
        private long value = 0;

        public java.lang.Long next() {
            return value++;
        }
    }

    public static class Float implements _109_Generator<java.lang.Float> {
        private float value = 0;

        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }
    }

    public static class Double implements _109_Generator<java.lang.Double> {
        private double value = 0.0;

        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }
}
