package generics;

import static common.utils.Print.print;
import static generics._121_Sets.complement;
import static generics._121_Sets.difference;
import static generics._121_Sets.intersection;
import static generics._121_Sets.union;
import static generics._122_Watercolors.*;

import java.util.EnumSet;
import java.util.Set;

public class _123_WatercolorSets {
    public static void main(String[] args) {
        Set<_122_Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<_122_Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + union(set1, set2));
        Set<_122_Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        print("difference(set1, subset): " + difference(set1, subset));
        print("difference(set2, subset): " + difference(set2, subset));
        print("complement(set1, set2): " + complement(set1, set2));
    }
}