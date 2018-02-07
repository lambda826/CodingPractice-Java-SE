package design_pattern.behavioral.strategy.demo2.duck;

import design_pattern.behavioral.strategy.demo2.fly.FlyWithWings;
import design_pattern.behavioral.strategy.demo2.quack.Quack;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
