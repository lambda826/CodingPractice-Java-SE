package interfaces;

import java.util.*;

public interface _120_RandVals {

    // Fields defined in interfaces cannot be "blank finals," but they can be initialized with nonconstant expressions
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextLong() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;

}
