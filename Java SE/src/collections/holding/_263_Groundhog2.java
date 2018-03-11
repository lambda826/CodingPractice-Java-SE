package collections.holding;

public class _263_Groundhog2 extends _260_Groundhog {
    public _263_Groundhog2(int n) {
        super(n);
    }

    public int hashCode() {
        return number;
    }

    public boolean equals(Object o) {
        return o instanceof _263_Groundhog2 && (number == ((_263_Groundhog2) o).number);
    }
}