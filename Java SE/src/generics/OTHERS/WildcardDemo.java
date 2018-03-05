/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 12:53:19 PM
 */

package generics.OTHERS;

public class WildcardDemo {
    public static void main(String args[]) {
        Integer inums[] = { 1, 2, 3, 4, 5 };
        Stats_Wildcard<Integer> iob = new Stats_Wildcard<Integer>(inums);
        double v = iob.average();
        System.out.println("iob average is " + v);

        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats_Wildcard<Double> dob = new Stats_Wildcard<Double>(dnums);
        double w = dob.average();
        System.out.println("dob average is " + w);

        Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
        Stats_Wildcard<Float> fob = new Stats_Wildcard<Float>(fnums);
        double x = fob.average();
        System.out.println("fob average is " + x);

        System.out.print("Averages of iob and dob ");
        if (iob.sameAvg(dob))
            System.out.println("are the same.");
        else
            System.out.println("differ.");

        System.out.print("Averages of iob and fob ");
        if (iob.sameAvg(fob))
            System.out.println("are the same.");
        else
            System.out.println("differ.");
    }
}