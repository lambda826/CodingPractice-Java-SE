/**
 *  @author  Yunxiang He
 *  @date    Feb 1, 2018 8:11:57 AM
 */

package design_pattern.behavioral.template;

public class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");

    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished");
    }

}
