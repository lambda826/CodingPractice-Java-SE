package clazz.innerClazz;

//Returning a reference to an inner class.
public class _02_Parcel2 {
    
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String dest) {
        Contents c = contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {
        _02_Parcel2 p = new _02_Parcel2();
        p.ship("Tasmania");
        _02_Parcel2 q = new _02_Parcel2();
        // Defining references to inner classes:
        _02_Parcel2.Contents c = q.contents();
        _02_Parcel2.Destination d = q.to("Borneo");
    }
}