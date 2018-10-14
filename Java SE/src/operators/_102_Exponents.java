package operators;

public class _102_Exponents {
    public static void main(String[] args) {
        // Uppercase and lowercase 'e' are the same:
        float expFloat = 1.39e-43f;
        expFloat = 1.39E-43f;
        System.out.println(expFloat);
        // 'd' is optional
        double expDouble = 47e47d;
        // Automatically double
        double expDouble2 = 47e47;
        System.out.println(expDouble);
        System.out.println(expDouble2);

        System.out.println(Integer.toBinaryString(-11123));
        System.out.println(Integer.toBinaryString(~-11123));
        System.out.println(-11123 + ~-11123);
    }
}