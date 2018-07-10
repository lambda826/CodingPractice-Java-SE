/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-01 01:40
 */

package common.obj;

public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}
