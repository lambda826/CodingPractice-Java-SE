package containers.hash;

public class _07_Individual implements Comparable<_07_Individual> {

    private static long counter = 0;
    private final long id = counter++;
    private String name;

    public _07_Individual() {
    }

    public _07_Individual(String name) {
        this.name = name;
    }

    public long id() {
        return id;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (name != null) {
            result = 37 * result + name.hashCode();
        }
        result = 37 * result + (int) id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof _07_Individual && id == ((_07_Individual) o).id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    public int compareTo(_07_Individual arg) {
        String first = getClass().getSimpleName();
        String argFirst = arg.getClass().getSimpleName();
        int firstCompare = first.compareTo(argFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && arg.name != null) {
            int secondCompare = name.compareTo(arg.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return (arg.id < id ? -1 : (arg.id == id ? 0 : 1));
    }
}
