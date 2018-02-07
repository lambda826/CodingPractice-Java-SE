package design_pattern.behavioral.strategy.demo2;

import design_pattern.behavioral.strategy.demo2.duck.Duck;
import design_pattern.behavioral.strategy.demo2.duck.MallardDuck;
import design_pattern.behavioral.strategy.demo2.duck.ModelDuck;
import design_pattern.behavioral.strategy.demo2.fly.FlyRocketPowered;

public class MiniDuckSimulator1 {

    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();

    }
}
