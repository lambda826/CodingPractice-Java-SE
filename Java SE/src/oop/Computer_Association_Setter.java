/**
 *  @author Yunxiang He
 *  @date   10/21/2018
 */

package oop;

// Association is relation between two separate classes which establishes through their Objects. 
// Association can be one-to-one, one-to-many, many-to-one, many-to-many.
public class Computer_Association_Setter {

    private String cpu;
    private double weight;
    private Monitor aMonitor;

    public Computer_Association_Setter(String cpu, double weight) {
        this.cpu = cpu;
        this.weight = weight;
    }

    public void setaMonitor(Monitor aMonitor) {
        this.aMonitor = aMonitor;
    }

    public void turnOn() {
        System.out.println("I am on.");
    }

    public static void main(String aa[]) {
        Computer_Association_Setter aComputer = new Computer_Association_Setter("Leo", 25);
        Monitor aMonitor = new Monitor(15, true);
        aComputer.setaMonitor(aMonitor);
        aComputer.turnOn();
    }
}
