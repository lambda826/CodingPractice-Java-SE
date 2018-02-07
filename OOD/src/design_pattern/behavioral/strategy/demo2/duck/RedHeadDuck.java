package design_pattern.behavioral.strategy.demo2.duck;

import design_pattern.behavioral.strategy.demo2.fly.FlyWithWings;
import design_pattern.behavioral.strategy.demo2.quack.Quack;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public void display() {
        System.out.println("I'm a real Red Headed duck");
    }
}
