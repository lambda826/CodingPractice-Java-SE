package interfaces;

import static utils.Print.*;

public class _121_TestRandVals {

    // Since the fields are static, they are initialized when the class is first loaded, which happens when any of the fields are accessed for the first time
    public static void main(String[] args) {
        print(_120_RandVals.RANDOM_INT);
        print(_120_RandVals.RANDOM_LONG);
        print(_120_RandVals.RANDOM_FLOAT);
        print(_120_RandVals.RANDOM_DOUBLE);
    }

}