package design_pattern.behavioral.strategy.demo2;

import design_pattern.behavioral.strategy.demo2.duck.DecoyDuck;
import design_pattern.behavioral.strategy.demo2.duck.Duck;
import design_pattern.behavioral.strategy.demo2.duck.MallardDuck;
import design_pattern.behavioral.strategy.demo2.duck.ModelDuck;
import design_pattern.behavioral.strategy.demo2.duck.RubberDuck;
import design_pattern.behavioral.strategy.demo2.fly.FlyRocketPowered;

public class MiniDuckSimulator {

    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        Duck rubberDuckie = new RubberDuck();
        Duck decoy = new DecoyDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        Duck model = new ModelDuck();
        
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
