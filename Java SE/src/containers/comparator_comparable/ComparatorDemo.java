/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-27
 */

package containers.comparator_comparable;

import java.util.Arrays;
import java.util.Comparator;

/*

Comparator是比较接口，我们如果需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)，那么我们就可以建立一个“该类的比较器”来进行排序，这个“比较器”只需要实现Comparator接口即可。
也就是说，我们可以通过实现Comparator来新建一个比较器，然后通过这个比较器对类进行排序。

*/

public class ComparatorDemo {
    public static void main(String[] args) {
        Person[] people = new Person[] { new Person("xujian", 20), new Person("xiewei", 10) };
        System.out.println("排序前");
        for (Person person : people) {
            System.out.print(person.getName() + ":" + person.getAge());
        }
        Arrays.sort(people, new PersonCompartor());
        System.out.println("\n排序后");
        for (Person person : people) {
            System.out.print(person.getName() + ":" + person.getAge());
        }
    }
}

class PersonCompartor implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
