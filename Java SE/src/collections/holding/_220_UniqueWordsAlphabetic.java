package collections.holding;

import java.util.Set;
import java.util.TreeSet;

import common.utils.TextFile;

public class _220_UniqueWordsAlphabetic {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(new TextFile("D:\\01__Development\\Coding Practice\\Java SE\\Java SE\\src\\collections\\holding\\_217_SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}