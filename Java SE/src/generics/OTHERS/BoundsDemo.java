/**
 *  @author  Yunxiang He
 *  @date    Feb 21, 2018 11:17:06 AM
 */

package generics.OTHERS;

public class BoundsDemo {
    public static void main(String args[]) {

        Integer inums[] = { 1, 2, 3, 4, 5 };
        Stats_BoundedType<Integer> iob = new Stats_BoundedType<Integer>(inums);
        double v = iob.average();
        System.out.println("iob average is " + v);

        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Stats_BoundedType<Double> dob = new Stats_BoundedType<Double>(dnums);
        double w = dob.average();
        System.out.println("dob average is " + w);

        // This won't compile because String is not a subclass of Number. 
        //        String strs[] = { "1", "2", "3", "4", "5" }; 
        //        Stats_BoundedType<String> strob = new Stats_BoundedType<String>(strs);   

        //        double x = strob.average(); 
        //        System.out.println("strob average is " + v); 

    }
}
