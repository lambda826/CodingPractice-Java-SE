package lambda;

import java.util.function.Predicate;

public class _07_MethodReference2 {

    public static int check(Predicate<Student> p, Student i) {
        return p.test(i) ? 1 : 0;
    }

    public static void main(String args[]) {
        Student student = new Student(20);
        Student::isGreater
    }
}

class Student {
    int num;

    public Student(int num) {
        this.num = num;
    }

    public boolean isGreater(int i) {
        return num > i;
    }

}
