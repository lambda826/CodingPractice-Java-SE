package collections.holding;

// Demonstrates performance differences in Sets.
// {Args: 100 5000} Small to keep build testing short
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _277_SetPerformance {
    static List<_272_Test<Set<Integer>>> tests = new ArrayList<_272_Test<Set<Integer>>>();
    static {
        tests.add(new _272_Test<Set<Integer>>("add") {
            int test(Set<Integer> set, _273_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++)
                        set.add(j);
                }
                return loops * size;
            }
        });
        tests.add(new _272_Test<Set<Integer>>("contains") {
            int test(Set<Integer> set, _273_TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        set.contains(j);
                return loops * span;
            }
        });
        tests.add(new _272_Test<Set<Integer>>("iterate") {
            int test(Set<Integer> set, _273_TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            _274_Tester.defaultParams = _273_TestParam.array(args);
        _274_Tester.fieldWidth = 10;
        _274_Tester.run(new TreeSet<Integer>(), tests);
        _274_Tester.run(new HashSet<Integer>(), tests);
        _274_Tester.run(new LinkedHashSet<Integer>(), tests);
    }
}