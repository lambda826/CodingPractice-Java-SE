package enumerations._03_basicMethodUse;
// No values() method if you upcast an enum

enum Search {
    HITHER, YON
}

public class UpcastEnum_getEnumConstants {
    public static void main(String[] args) {
        Search[] vals = Search.values();

        // Upcast
        Enum e = Search.HITHER;

        // Because values( ) is a static method inserted into the enum definition by the compiler, if you upcast an enum type to Enum, the values( ) method will not be available e.values(); 
        // No values() in Enum
        for (Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}