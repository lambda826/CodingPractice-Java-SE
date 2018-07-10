package array;

public class _109_VarargType {
    static void f(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void g(int... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    public static void main(String[] args) {
        f('a');
        f();
        //  The ‘I’ is for a primitive int
        g(1);
        g();
        System.out.println("int[]: " + new int[0].getClass());
    }
}