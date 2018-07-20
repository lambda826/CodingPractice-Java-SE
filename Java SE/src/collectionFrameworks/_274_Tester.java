package collectionFrameworks;

import java.util.*;

public class _274_Tester<C> {
    public static int fieldWidth = 8;
    public static _273_TestParam[] defaultParams = _273_TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);

    // Override this to modify pre-test initialization:
    protected C initialize(int size) {
        return container;
    }

    protected C container;
    private String headline = "";
    private List<_272_Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;
    private static String sizeField = "%" + sizeWidth + "s";
    private _273_TestParam[] paramList = defaultParams;

    public _274_Tester(C container, List<_272_Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null)
            headline = container.getClass().getSimpleName();
    }

    public _274_Tester(C container, List<_272_Test<C>> tests, _273_TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadline(String newHeadline) {
        headline = newHeadline;
    }

    // Generic methods for convenience :
    public static <C> void run(C cntnr, List<_272_Test<C>> tests) {
        new _274_Tester<C>(cntnr, tests).timedTest();
    }

    public static <C> void run(C cntnr, List<_272_Test<C>> tests, _273_TestParam[] paramList) {
        new _274_Tester<C>(cntnr, tests, paramList).timedTest();
    }

    private void displayHeader() {
        // Calculate width and pad with '-':
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headline.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        head.append(' ');
        head.append(headline);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        System.out.println(head);
        // Print column headers:
        System.out.format(sizeField, "size");
        for (_272_Test test : tests)
            System.out.format(stringField(), test.name);
        System.out.println();
    }

    // Run the tests for this container:
    public void timedTest() {
        displayHeader();
        for (_273_TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (_272_Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                // Call the overriden method:
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                // Nanoseconds
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}
