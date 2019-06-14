/**
 *  @author Yunxiang He
 *  @date   06/02/2019
 */

package java8.lambda.interfaces;

import java8.lambda.pojos.EmptyArrayException;

public interface DoubleNumberArrayFunc {
    double func(double[] n) throws EmptyArrayException;
}