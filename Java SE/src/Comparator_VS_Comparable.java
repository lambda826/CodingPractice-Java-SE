/**
 *    Copyright 2017 Yunxiang He
 *
 *    All right reserved.
 * 
 *    Create on Oct 23, 2017 6:19:41 PM
 */


import java.util.Comparator;

/**
 * @author Yunxiang He
 * @date Oct 23, 2017 6:19:41 PM
 */
public class Comparator_VS_Comparable {

    static class Person implements Comparable<Object> {
        private int num;
        private String name;
        private int age;

        public Person(int num, String name, int age) {
            super();
            this.num = num;
            this.name = name;
            this.age = age;
        }

        public int compareTo(Object o) {
            return this.age - ((Person) o).getAge();
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    // ʵ��Comparator�ӿ�
    static class PersonComparator implements Comparator<Object> {
        @Override
        public int compare(Object o1, Object o2) {
            int num1 = ((Person) o1).getNum();
            int num2 = ((Person) o2).getNum();
            return num1 > num2 ? 1 : (num1 == num2 ? 0 : -1);
        }
    }

    // ����
    public static class PersonTest {
        public static void main(String[] args) {
            Person p1 = new Person(1, "xy1", 22);
            Person p2 = new Person(2, "xy1", 21);
            System.out.println("ʵ��Comparable�ӿڷ������(������Ƚ�)��"); // ���Ϊ1
            System.out.println(p1.compareTo(p2));

            System.out.println("ʵ��Comparator�ӿڷ������(��ѧ�űȽ�)��"); // ���Ϊ-1
            PersonComparator pc = new PersonComparator();
            System.out.println(pc.compare(p1, p2));

            // Ҳ��������һ��Person[] ps��ͨ��Array.sort(ps)��������
        }
    }

}
