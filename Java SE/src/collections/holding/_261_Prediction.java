package collections.holding;

import java.util.*;

public class _261_Prediction {
    private static Random rand = new Random(47);
    private boolean shadow = rand.nextDouble() > 0.5;

    public String toString() {
        if (shadow)
            return "Six more weeks of Winter!";
        else
            return "Early Spring!";
    }
}