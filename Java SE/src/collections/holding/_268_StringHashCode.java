package collections.holding;

public class _268_StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
        System.out.println(new String("Hello").hashCode());
    }
}