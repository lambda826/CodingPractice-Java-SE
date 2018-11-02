package enumerated;
// No values() method if you upcast an enum

enum Search {
    HITHER, YON
}

public class _108_UpcastEnum_NoValues {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        // Upcast
        Enum e = Search.HITHER;
        // No values() in Enum
        // e.values(); 
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}