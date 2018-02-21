package enumerations;

public class _218_Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (_217_Course course : _217_Course.values()) {
                Food_EnumsInterface food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}