package generics._09_Wildcards;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
    // Compile Error: incompatible types:
    //    List<Fruit> flist = new ArrayList<Apple>();
}
