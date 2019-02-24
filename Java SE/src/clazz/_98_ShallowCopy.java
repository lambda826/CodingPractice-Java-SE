/**
 *  @author Yunxiang He
 *  @date   02/23/2019
 */

package clazz;

public class _98_ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setName("Delacey");

        Student student1 = new Student();
        student1.setName("Dream");
        student1.setTeacher(teacher);

        Student student2 = (Student) student1.clone();
        System.out.println("拷贝后");
        System.out.println(student2.getName());
        System.out.println(student2.getTeacher().getName());
        System.out.println("修改老师的信息后-------------");

        teacher.setName("Jam");
        System.out.println(student1.getTeacher().getName());
        System.out.println(student2.getTeacher().getName());
    }

    static class Teacher implements Cloneable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }

    static class Student implements Cloneable {
        private String name;
        private Teacher teacher;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

    }
}
