/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-21
 */

package oop;


public class Computer_Association {

    private String cpu;
    private double weight;
    private Monitor aMonitor;

    public Computer_Association(String cpu, double weight) {
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
        Computer_Association aComputer = new Computer_Association("Leo", 25);
        Monitor aMonitor = new Monitor(15, true);
        aComputer.setaMonitor(aMonitor);
        aComputer.turnOn();
    }
}
