/**
 *  @author  Yunxiang He
 *  @date    Feb 10, 2018 9:19:39 PM
 */

package interface_abstractClass.completeDecoupling;

/*

Filter has the same interface elements as Processor, but because it isn’t inherited from Processor\
because the creator of the Filter class had no clue you might want to use it as a Processor
you can’t use a Filter with the Apply.process( ) method, even though it would work fine

 */

public class Filter {

    public String name() {
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input) {
        return input;
    }
}