/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-21
 */

package oop;

// Composition is again a specialized form of Aggregation and we can call this as a “death” relationship. It is a strong type of Aggregation. 
// Child objects does not have their life cycle and if the parent object is deleted all child objects will also be deleted.
public class Computer_Composition_ConstructorField {

    private String cpu;
    private double weight;
    private Monitor aMonitor;

    public Computer_Composition_ConstructorField(String cpu, double weight, int inch, boolean isFlat) {
        this.cpu = cpu;
        this.weight = weight;
        this.aMonitor = new Monitor(inch, isFlat);
    }

    public void turnOn() {
        System.out.println("I am on.");
    }

    public static void main(String aa[]) {

        //Monitor aMonitor=new Monitor(15, true);
        Computer_Composition_ConstructorField aComputer = new Computer_Composition_ConstructorField("586", 32.0, 15, true);
        System.out.println("Computer is :" + aComputer);
        aComputer.turnOn();

    }
}
