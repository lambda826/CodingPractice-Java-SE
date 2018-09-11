package containers.array;

import generics._109_Generator;

public class _129_GeneratorsTest {
    public static int size = 10;

    public static void test(Class<?> surroundingClass) {
        for (Class<?> type : surroundingClass.getClasses()) {
            System.out.print(type.getSimpleName() + ": ");
            try {
                _109_Generator<?> g = (_109_Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.printf(g.next() + " ");
                }
                System.out.println();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        test(_128_CountingGenerator.class);
    }
}