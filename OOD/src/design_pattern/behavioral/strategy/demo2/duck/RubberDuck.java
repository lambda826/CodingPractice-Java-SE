package design_pattern.behavioral.strategy.demo2.duck;

import design_pattern.behavioral.strategy.demo2.fly.FlyNoWay;
import design_pattern.behavioral.strategy.demo2.quack.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public void display() {
        System.out.println("I'm a rubber duckie");
    }
}
