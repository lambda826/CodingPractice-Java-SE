/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-21
 */

package oop;


public class Computer_Composition {

    private String cpu;
    private double weight;
    private Monitor aMonitor;

    public Computer_Composition(String cpu, double weight, int inch, boolean isFlat) {
        this.cpu = cpu;
        this.weight = weight;
        this.aMonitor = new Monitor(inch, isFlat);
    }

    public void turnOn() {
        System.out.println("I am on.");
    }
    public static void main(String aa[]) {

        //Monitor aMonitor=new Monitor(15, true);
        Computer_Composition aComputer = new Computer_Composition("586", 32.0, 15, true);
        System.out.println("Computer is :" + aComputer);
        aComputer.turnOn();

    }
}


