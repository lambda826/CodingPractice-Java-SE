/**
 *  @author  Yunxiang He
 *  @date    Feb 6, 2018 2:49:58 AM
 */

package collections.list;

import java.util.HashSet;

public class HashSetDemo {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");

        System.out.println(hs); // [Gamma, Eta, Alpha, Epsilon, Omega, Beta]

        
    }
}
