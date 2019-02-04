package clazz.innerClazz;

//Qualifying access to the outer-class object.
public class _04_DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public _04_DotThis outer() {
            // A plain "this" would be Inner's "this"
            return _04_DotThis.this;

        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        _04_DotThis dt = new _04_DotThis();
        _04_DotThis.Inner dti = dt.inner();
        dti.outer().f();
    }
}