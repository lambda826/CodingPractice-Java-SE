package collections.holding;

import java.util.Set;
import java.util.TreeSet;

import common.utils.TextFile;

public class _219_UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(new TextFile("D:\\01__Development\\Coding Practice\\Java SE\\Java SE\\src\\collections\\holding\\_217_SetOperations.java", "\\W+"));
        System.out.println(words);
    }
}