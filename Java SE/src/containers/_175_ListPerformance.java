package containers;

// {Args: 100 500} Small to keep build testing short
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Vector;

import containers.array._128_CountingGenerator;
import containers.array._132_Generated;

public class _175_ListPerformance {
    static Random rand = new Random();
    static int reps = 1000;
    static List<_172_Test<List<Integer>>> tests = new ArrayList<_172_Test<List<Integer>>>();
    static List<_172_Test<LinkedList<Integer>>> qTests = new ArrayList<_172_Test<LinkedList<Integer>>>();
    static {
        tests.add(new _172_Test<List<Integer>>("add") {
            int test(List<Integer> list, _173_TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(j);
                }
                return loops * listSize;
            }
        });
        tests.add(new _172_Test<List<Integer>>("get") {
            int test(List<Integer> list, _173_TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new _172_Test<List<Integer>>("set") {
            int test(List<Integer> list, _173_TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), 47);
                return loops;
            }
        });
        tests.add(new _172_Test<List<Integer>>("iteradd") {
            int test(List<Integer> list, _173_TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<Integer> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add(47);
                return LOOPS;
            }
        });
        tests.add(new _172_Test<List<Integer>>("insert") {
            int test(List<Integer> list, _173_TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    list.add(5, 47); // Minimize random-access cost
                return loops;
            }
        });
        tests.add(new _172_Test<List<Integer>>("remove") {
            int test(List<Integer> list, _173_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new _145_CountingIntegerList(size));
                    while (list.size() > 5)
                        // Minimize random-access cost
                        list.remove(5);
                }
                return loops * size;
            }
        });
        // Tests for queue behavior:
        qTests.add(new _172_Test<LinkedList<Integer>>("addFirst") {
            int test(LinkedList<Integer> list, _173_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            }
        });
        qTests.add(new _172_Test<LinkedList<Integer>>("addLast") {
            int test(LinkedList<Integer> list, _173_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast(47);
                }
                return loops * size;
            }
        });
        qTests.add(new _172_Test<LinkedList<Integer>>("rmFirst") {
            int test(LinkedList<Integer> list, _173_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new _145_CountingIntegerList(size));
                    while (list.size() > 0)
                        list.removeFirst();
                }
                return loops * size;
            }
        });
        qTests.add(new _172_Test<LinkedList<Integer>>("rmLast") {
            int test(LinkedList<Integer> list, _173_TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new _145_CountingIntegerList(size));
                    while (list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends _174_Tester<List<Integer>> {
        public ListTester(List<Integer> container, List<_172_Test<List<Integer>>> tests) {
            super(container, tests);
        }

        // Fill to the appropriate size before each test:
        @Override
        protected List<Integer> initialize(int size) {
            container.clear();
            container.addAll(new _145_CountingIntegerList(size));
            return container;
        }

        // Convenience method:
        public static void run(List<Integer> list, List<_172_Test<List<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0)
            _174_Tester.defaultParams = _173_TestParam.array(args);
        // Can only do these two tests on an array:
        _174_Tester<List<Integer>> arrayTest = new _174_Tester<List<Integer>>(null, tests.subList(1, 3)) {
            // This will be called before each test. 
            // It produces a non-resizeable array-backed list:
            @Override
            protected List<Integer> initialize(int size) {
                Integer[] ia = _132_Generated.array(Integer.class, new _128_CountingGenerator.Integer(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        _174_Tester.defaultParams = _173_TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0)
            _174_Tester.defaultParams = _173_TestParam.array(args);
        ListTester.run(new ArrayList<Integer>(), tests);
        ListTester.run(new LinkedList<Integer>(), tests);
        ListTester.run(new Vector<Integer>(), tests);
        _174_Tester.fieldWidth = 12;
        _174_Tester<LinkedList<Integer>> qTest = new _174_Tester<LinkedList<Integer>>(new LinkedList<Integer>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}