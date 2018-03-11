package collections.holding;

import java.util.ArrayList;
import java.util.HashSet;

import common.utils.RandomGenerator;

public class _240_CollectionDataGeneration {
    public static void main(String[] args) {
        // Convenience method
        System.out.println(new ArrayList<String>(_238_CollectionData.list(new RandomGenerator.String(9), 10)));
        System.out.println(new HashSet<Integer>(new _238_CollectionData<Integer>(new RandomGenerator.Integer(), 10)));
    }
}