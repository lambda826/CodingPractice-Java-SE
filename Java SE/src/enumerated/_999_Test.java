/**
 *  @author: Yunxiang He
 *  @date  : 2018-11-02
 */

package enumerated;

enum EnumDemo {

    A(1, 5), B(2, 2), C(4, 4);

    int _a;
    int _b;

    EnumDemo(int a, int b) {
        this._a = a;
        this._b = b;
    }

    public int get_a() {
        return _a;
    }

    public void set_a(int _a) {
        this._a = _a;
    }

    public int get_b() {
        return _b;
    }

    public void set_b(int _b) {
        this._b = _b;
    }

}

public class _999_Test {
    public static void main(String[] args) {
        EnumDemo a = EnumDemo.A;
        System.out.println(a._a);

        switch (a) {
        case A:
            System.out.println(a);
            break;
        default:
            System.out.println("defal");
        }

        a.set_a(100);
        System.out.println(a.get_a());
    }
}
