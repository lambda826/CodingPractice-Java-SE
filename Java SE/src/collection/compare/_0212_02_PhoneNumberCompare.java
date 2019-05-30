package collection.compare;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;

public class _0212_02_PhoneNumberCompare {

    public static class PhoneNumber implements Comparable<PhoneNumber> {

        short areaCode;
        short prefix;
        short lineNum;

        /*
         * If a class has multiple significant fields, the order in which you compare
         * them is critical. Start with the most significant field and work your way
         * down. If a comparison results in anything other than zero (which represents
         * equality), you’re done; just return the result. If the most significant field
         * is equal, compare the next-most-significant field, and so on, until you find
         * an unequal field or compare the least significant field
         */
        public int compareTo(PhoneNumber pn) {
            int result = Short.compare(areaCode, pn.areaCode);
            if (result == 0) {
                result = Short.compare(prefix, pn.prefix);
                if (result == 0)
                    result = Short.compare(lineNum, pn.lineNum);
            }
            return result;
        }

        /*
         * CompartorConstructionMethods
         * 
         * In Java 8, the Comparator interface was outfit with a set of comparator
         * construction methods, which enable fluent construction of comparators These
         * comparators can then be used to implement a compareTo method, as required by
         * the Comparable interface.
         */
        private static final Comparator<PhoneNumber> COMPARATOR = comparingInt((PhoneNumber pn) -> pn.areaCode).thenComparingInt(pn -> pn.prefix).thenComparingInt(pn -> pn.lineNum);

        public int compareTo2(PhoneNumber pn) {
            return COMPARATOR.compare(this, pn);
        }

        /*
         * Occasionally you may see compareTo or compare methods that rely on the fact
         * that the difference between two values is negative if the first value is less
         * than the second, zero if the two values are equal, and positive if the first
         * value is greater
         */
        static Comparator<Object> hashCodeOrder = new Comparator<>() {
            public int compare(Object o1, Object o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());// Use either a static compare method

            }
        };

        static Comparator<Object> hashCodeOrder2 = Comparator.comparingInt(o -> o.hashCode()); // or a comparator construction method

    }
}
