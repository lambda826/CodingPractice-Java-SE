package clazz;

import multithreadedProgramming.communication.deadLockDemo.A;

public class _106_NewVarArgs {
    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    //    static void printArray(int... args) {
    //        for (int i : args) {
    //            System.out.print(i + " ");
    //        }
    //        System.out.println();
    //        
    //    }

    public static void main(String[] args) {
        // Can take individual elements:
        printArray(new Integer(47), new Float(3.14), new Double(11.11));
        printArray(47, 3.14F, 11.11);
        printArray("one", "two", "three");
        printArray(new A(), new A(), new A(), new int[] {});
        // Or an array:
        printArray((Object[]) new Integer[] { 1, 2, 3, 4 });
        // Empty list is OK
        printArray();
    }

}