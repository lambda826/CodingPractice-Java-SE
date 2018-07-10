package collections.holding;

import java.util.ArrayList;
import java.util.HashSet;

import array._130_RandomGenerator;

public class _240_CollectionDataGeneration {
    public static void main(String[] args) {
        // Convenience method
        System.out.println(new ArrayList<String>(_238_CollectionData.list(new _130_RandomGenerator.String(9), 10)));
        System.out.println(new HashSet<Integer>(new _238_CollectionData<Integer>(new _130_RandomGenerator.Integer(), 10)));
    }
}