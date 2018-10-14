package generics;

class Building {
}

class House extends Building {
}

public class _142_ClassTypeCapture<T> {

    // sometimes you must compensate for erasure by introducing a type tag. 
    // This means you explicitly pass in the Class object for your type so that you can use it in type expressions.
    Class<T> kind;

    public _142_ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
        _142_ClassTypeCapture<Building> ctt1 = new _142_ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        _142_ClassTypeCapture<House> ctt2 = new _142_ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
    }
}