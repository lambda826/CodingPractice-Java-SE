package generics._03_GenericMethods.SetsUtility;

import static common.utils.Print.print;
import static generics._03_GenericMethods.SetsUtility.Sets.complement;
import static generics._03_GenericMethods.SetsUtility.Sets.difference;
import static generics._03_GenericMethods.SetsUtility.Sets.intersection;
import static generics._03_GenericMethods.SetsUtility.Sets.union;
import static generics._03_GenericMethods.SetsUtility.Watercolors.*;

import java.util.EnumSet;
import java.util.Set;

public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        print("difference(set1, subset): " + difference(set1, subset));
        print("difference(set2, subset): " + difference(set2, subset));
        print("complement(set1, set2): " + complement(set1, set2));
    }
}