package enumerations._04_useEnum;

enum Activity {
    SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING
}

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            System.out.print(RandomGenerator.random(Activity.class) + " ");

        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(RandomGenerator.random(Activity.values()) + " ");
        }
    }
}
