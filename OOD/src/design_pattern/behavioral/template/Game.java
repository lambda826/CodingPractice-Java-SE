/**
 *  @author  Yunxiang He
 *  @date    Feb 1, 2018 8:10:43 AM
 */

package design_pattern.behavioral.template;

public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
