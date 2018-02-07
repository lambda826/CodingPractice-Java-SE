package design_pattern.behavioral.strategy.demo2.fly;

public class FlyNoWay implements FlyBehavior {
    
    public void fly() {
        System.out.println("I can't fly");
    }
    
}
