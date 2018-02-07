package design_pattern.behavioral.strategy.demo2.quack;

public class FakeQuack implements QuackBehavior {
    
    public void quack() {
        System.out.println("Qwak");
    }
    
}
