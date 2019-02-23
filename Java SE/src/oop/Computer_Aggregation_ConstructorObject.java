/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-21
 */

package oop;

// It represents Has-A relationship.
// It is a unidirectional association i.e. a one way relationship. For example, department can have students but vice versa is not possible and thus unidirectional in nature.
// In Aggregation, both the entries can survive individually which means ending one entity will not effect the other entity
public class Computer_Aggregation_ConstructorObject {

    private String cpu;
    private double weight;
    private Monitor aMonitor;

    public Computer_Aggregation_ConstructorObject(String cpu, double weight, Monitor aMonitor) {
        this.cpu = cpu;
        this.weight = weight;
        this.aMonitor = aMonitor;
    }

    public void turnOn() {
        System.out.println("I am on.");
    }

    public static void main(String aa[]) {

        Monitor aMonitor = new Monitor(15, true);
        System.out.println("I do something others here");
        Computer_Aggregation_ConstructorObject aComputer = new Computer_Aggregation_ConstructorObject("586", 32.0, aMonitor);
        System.out.println("Computer is :" + aComputer);
        aComputer.turnOn();
    }

}
