/**
 *  @author: Yunxiang He
 *  @date  : 2018-07-28 18:59
 */

package containers.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*

when you create your own classes to be used as keys for HashMaps
You should override hashCode() and equals() method inherited from o

*/

class Key {
    String name;
}

class Value {
}

class Class_1 extends Key {

    public Class_1(String name) {
        this.name = name;
    }
}

class Class_2 extends Key {

    public Class_2(String name) {
        this.name = name;
    }

    // hashCode() is not required to return a unique identifier
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    // equals() method must strictly determine whether two os are equivalent
    // if two objects are equal, they have to have the same hashCode
    @Override
    public boolean equals(Object o) {
        return o instanceof Class_2 && ((Class_2) o).name.equals(name);
    }
}

class Class_3 extends Key {

    public Class_3(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return new Random().nextInt();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Class_3 && ((Class_3) o).name.equals(name);
    }
}

public class _01_HashDemo {

    public static void main(String[] args) {
        Map<Key, Value> map = new HashMap<>();
        map.put(new Class_1("Class_1"), new Value());
        map.put(new Class_2("Class_2"), new Value());
        map.put(new Class_3("Class_3"), new Value());
        System.out.println(map.containsKey(new Class_1("Class_1")));
        System.out.println(map.containsKey(new Class_2("Class_2")));
        System.out.println(map.containsKey(new Class_3("Class_3")));

    }
}
