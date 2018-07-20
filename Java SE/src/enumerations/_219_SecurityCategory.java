package enumerations;

import enumerations._04_useEnum.RandomGenerator;

enum _219_SecurityCategory {
    STOCK(Security.Stock.class), BOND(Security.Bond.class);
    Security[] values;

    _219_SecurityCategory(Class<? extends Security> kind) {
        values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return RandomGenerator.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            _219_SecurityCategory category = RandomGenerator.random(_219_SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
} /* Output:
  BOND: MUNICIPAL
  BOND: MUNICIPAL
  STOCK: MARGIN
  STOCK: MARGIN
  BOND: JUNK
  STOCK: SHORT
  STOCK: LONG
  STOCK: LONG
  BOND: MUNICIPAL
  BOND: JUNK
  *///:~
