package collections.holding;

import java.util.*;

public class _225_PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++)
            priorityQueue.offer(rand.nextInt(i + 10));
        _224_QueueDemo.printQ(priorityQueue);

        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<Integer>(ints);
        _224_QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        _224_QueueDemo.printQ(priorityQueue);

        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>(strings);
        _224_QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        _224_QueueDemo.printQ(stringPQ);

        Set<Character> charSet = new HashSet<Character>();
        for (char c : fact.toCharArray())
            // Autoboxing
            charSet.add(c);
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
        _224_QueueDemo.printQ(characterPQ);
    }
}