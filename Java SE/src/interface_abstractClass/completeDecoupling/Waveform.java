/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 9:18:37 PM
 */

package interface_abstractClass.completeDecoupling;

public class Waveform {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Waveform " + id;
    }
}
