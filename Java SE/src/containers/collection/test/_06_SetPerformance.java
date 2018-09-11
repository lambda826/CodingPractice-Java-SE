package containers.collection.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _06_SetPerformance {
    static List<_01_Test<Set<Integer>>> tests = new ArrayList<_01_Test<Set<Integer>>>();
    static {
        tests.add(new _01_Test<Set<Integer>>("add") {
            int test(Set<Integer> set, _02_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++) {
                        set.add(j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new _01_Test<Set<Integer>>("contains") {
            int test(Set<Integer> set, _02_TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++) {
                    for (int j = 0; j < span; j++) {
                        set.contains(j);
                    }
                }
                return loops * span;
            }
        });
        tests.add(new _01_Test<Set<Integer>>("iterate") {
            int test(Set<Integer> set, _02_TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            _03_Tester.defaultParams = _02_TestParam.array(args);
        }
        _03_Tester.fieldWidth = 10;
        _03_Tester.run(new TreeSet<Integer>(), tests);
        _03_Tester.run(new HashSet<Integer>(), tests);
        _03_Tester.run(new LinkedHashSet<Integer>(), tests);
    }
}