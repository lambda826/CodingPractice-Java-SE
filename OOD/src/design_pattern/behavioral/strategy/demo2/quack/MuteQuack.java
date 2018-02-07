package design_pattern.behavioral.strategy.demo2.quack;

public class MuteQuack implements QuackBehavior {
    
    public void quack() {
        System.out.println("<< Silence >>");
    }
    
}
