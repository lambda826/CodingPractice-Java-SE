package collections.holding;

public class _270_Individual implements Comparable<_270_Individual> {
    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public _270_Individual(String name) {
        this.name = name;
    }

    public _270_Individual() {
    }

    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public long id() {
        return id;
    }

    public boolean equals(Object o) {
        return o instanceof _270_Individual && id == ((_270_Individual) o).id;
    }

    public int hashCode() {
        int result = 17;
        if (name != null)
            result = 37 * result + name.hashCode();
        result = 37 * result + (int) id;
        return result;
    }

    public int compareTo(_270_Individual arg) {
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0)
            return firstCompare;
        if (name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0)
                return secondCompare;
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}
