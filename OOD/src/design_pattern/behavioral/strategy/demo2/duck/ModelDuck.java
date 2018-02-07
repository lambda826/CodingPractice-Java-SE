package design_pattern.behavioral.strategy.demo2.duck;

import design_pattern.behavioral.strategy.demo2.fly.FlyNoWay;
import design_pattern.behavioral.strategy.demo2.quack.Quack;

public class ModelDuck extends Duck {
    
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a model duck");
    }
}
