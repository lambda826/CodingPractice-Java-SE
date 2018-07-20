package collectionFrameworks;

import static common.utils.Print.*;

// What will the weather be?
import java.lang.reflect.*;
import java.util.*;

public class _262_SpringDetector {
    // Uses a Groundhog or class derived from Groundhog:
    public static <T extends _260_Groundhog> void detectSpring(Class<T> type) throws Exception {

        Constructor<T> ghog = type.getConstructor(int.class);

        Map<_260_Groundhog, _261_Prediction> map = new HashMap<_260_Groundhog, _261_Prediction>();

        for (int i = 0; i < 10; i++)
            map.put(ghog.newInstance(i), new _261_Prediction());

        print("map = " + map);
        _260_Groundhog gh = ghog.newInstance(3);
        print("Looking up prediction for " + gh);
        if (map.containsKey(gh))
            print(map.get(gh));
        else
            print("Key not found: " + gh);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(_260_Groundhog.class);
    }
}