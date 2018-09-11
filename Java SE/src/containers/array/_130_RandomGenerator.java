package containers.array;

import java.util.Random;

import generics._109_Generator;

public class _130_RandomGenerator {

    private static Random r = new Random(47);

    public static class Boolean implements _109_Generator<java.lang.Boolean> {
        public java.lang.Boolean next() {
            return r.nextBoolean();
        }
    }

    public static class Byte implements _109_Generator<java.lang.Byte> {
        public java.lang.Byte next() {
            return (byte) r.nextInt();
        }
    }

    public static class Character implements _109_Generator<java.lang.Character> {
        public java.lang.Character next() {
            return _128_CountingGenerator.chars[r.nextInt(_128_CountingGenerator.chars.length)];
        }
    }

    public static class String extends _128_CountingGenerator.String {
        // Plug in the random Character generator:
        // Instance initializer
        {
            cg = new Character();
        }

        public String() {
        }

        public String(int length) {
            super(length);
        }
    }

    public static class Short implements _109_Generator<java.lang.Short> {
        public java.lang.Short next() {
            return (short) r.nextInt();
        }
    }

    public static class Integer implements _109_Generator<java.lang.Integer> {

        private int mod = 10000;

        public Integer() {
        }

        public Integer(int modulo) {
            mod = modulo;
        }

        public java.lang.Integer next() {
            return r.nextInt(mod);
        }
    }

    public static class Long implements _109_Generator<java.lang.Long> {

        private int mod = 10000;

        public Long() {
        }

        public Long(int modulo) {
            mod = modulo;
        }

        public java.lang.Long next() {
            return new java.lang.Long(r.nextInt(mod));
        }
    }

    public static class Float implements _109_Generator<java.lang.Float> {
        public java.lang.Float next() {
            // Trim all but the first two decimal places:
            int trimmed = Math.round(r.nextFloat() * 100);
            return ((float) trimmed) / 100;
        }
    }

    public static class Double implements _109_Generator<java.lang.Double> {
        public java.lang.Double next() {
            long trimmed = Math.round(r.nextDouble() * 100);
            return ((double) trimmed) / 100;
        }
    }
}