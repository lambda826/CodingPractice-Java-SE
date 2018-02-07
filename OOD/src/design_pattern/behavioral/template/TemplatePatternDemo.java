/**
 *  @author  Yunxiang He
 *  @date    Feb 1, 2018 8:13:44 AM
 */

package design_pattern.behavioral.template;

public class TemplatePatternDemo {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Footbal();
        game.play();
    }
}
