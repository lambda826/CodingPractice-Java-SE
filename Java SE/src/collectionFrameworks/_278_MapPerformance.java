package collectionFrameworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class _278_MapPerformance {
    static List<_272_Test<Map<Integer, Integer>>> tests = new ArrayList<_272_Test<Map<Integer, Integer>>>();
    static {
        tests.add(new _272_Test<Map<Integer, Integer>>("put") {
            int test(Map<Integer, Integer> map, _273_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++)
                        map.put(j, j);
                }
                return loops * size;
            }
        });
        tests.add(new _272_Test<Map<Integer, Integer>>("get") {
            int test(Map<Integer, Integer> map, _273_TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        map.get(j);
                return loops * span;
            }
        });
        tests.add(new _272_Test<Map<Integer, Integer>>("iterate") {
            int test(Map<Integer, Integer> map, _273_TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext())
                        it.next();
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            _274_Tester.defaultParams = _273_TestParam.array(args);
        _274_Tester.run(new TreeMap<Integer, Integer>(), tests);
        _274_Tester.run(new HashMap<Integer, Integer>(), tests);
        _274_Tester.run(new LinkedHashMap<Integer, Integer>(), tests);
        _274_Tester.run(new IdentityHashMap<Integer, Integer>(), tests);
        _274_Tester.run(new WeakHashMap<Integer, Integer>(), tests);
        _274_Tester.run(new Hashtable<Integer, Integer>(), tests);
    }
}