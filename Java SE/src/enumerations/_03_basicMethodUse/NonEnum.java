package enumerations._03_basicMethodUse;

public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            // Because getEnumConstants() is a method of Class, you can call it for a class that has no enumerations
            // However, the method returns null, so you get an exception if you try to use the result.
            for (Object en : intClass.getEnumConstants())
                System.out.println(en);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}