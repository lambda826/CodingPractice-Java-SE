/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-21
 */

package oop;



public class Computer_Aggregation {

    private String cpu;
    private double weight;
    private Monitor aMonitor;

    public Computer_Aggregation(String cpu, double weight, Monitor aMonitor) {
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
        Computer_Aggregation aComputer = new Computer_Aggregation("586", 32.0, aMonitor);
        System.out.println("Computer is :" + aComputer);
        aComputer.turnOn();
    }

}
