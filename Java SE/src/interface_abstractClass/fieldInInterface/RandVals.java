/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 10:00:18 PM
 */

package interface_abstractClass.fieldInInterface;

import java.util.Random;

public interface RandVals {
    Random RAND = new Random(47);
    int RANDOM_INT = RAND.nextInt(10);
    long RANDOM_LONG = RAND.nextLong() * 10;
    float RANDOM_FLOAT = RAND.nextLong() * 10;
    double RANDOM_DOUBLE = RAND.nextDouble() * 10;
}
