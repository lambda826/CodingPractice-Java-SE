/**
 *  @author: Yunxiang He
 *  @date  : 2018-10-27
 */

package containers.comparator_comparable;

import java.util.Arrays;

/*

Comparable是排序接口。若一个类实现了Comparable接口，就意味着该类支持排序。
实现了Comparable接口的类的对象的列表或数组可以通过Collections.sort或Arrays.sort进行自动排序。
此外，实现此接口的对象可以用作有序映射中的键或有序集合中的集合，无需指定比较器。该接口定义如下

*/
public class ComparableDemo {

    public static void main(String[] args) {
        Person[] people = { new Person("xujian", 20), new Person("xiewei", 10) };
        System.out.println("排序前");
        for (Person person : people) {
            System.out.print(person.getName() + ":" + person.getAge());
        }
        Arrays.sort(people);
        System.out.println("\n排序后");
        for (Person person : people) {
            System.out.print(person.getName() + ":" + person.getAge());
        }
    }
}

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person p) {
        return this.age - p.getAge();
    }
}