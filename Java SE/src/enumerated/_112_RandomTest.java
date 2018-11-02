package enumerated;

enum Activity {
    SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING
}

public class _112_RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(_111_Enums.random(Activity.class) + " ");
        }
    }
}