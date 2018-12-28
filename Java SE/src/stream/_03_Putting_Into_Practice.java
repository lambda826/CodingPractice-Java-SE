package stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Trader {

    private String name;
    private String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
    }
}

public class _03_Putting_Into_Practice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        System.out.println("----- Query 1: Find all transactions from year 2011 and sort them by value (small to high). -----");
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList()).forEach(System.out::println);
        System.out.println();

        // Query 2: What are all the unique cities where the traders work?
        System.out.println("----- Query 2: What are all the unique cities where the traders work? -----");
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList()).forEach(System.out::println);
        System.out.println();

        // Query 3: Find all traders from Cambridge and sort them by name.
        System.out.println("----- Query 3: Find all traders from Cambridge and sort them by name. -----");
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName)).collect(toList()).forEach(System.out::println);
        System.out.println();

        // Query 4: Return a string of all traders’ names sorted alphabetically. 
        System.out.println("----- Query 4: Return a string of all traders’ names sorted alphabetically. -----");
        System.out.println(transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().reduce((n1, n2) -> n1 + " " + n2).get());
        System.out.println();

        // Query 5: Are there any trader based in Milan?
        System.out.println("----- Query 5: Are there any trader based in Milan? -----");
        System.out.println(transactions.stream().map(Transaction::getTrader).map(Trader::getCity).anyMatch(city -> city.equals("Milan")));
        System.out.println();

        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        System.out.println("----- Query 6: Update all transactions so that the traders from Milan are set to Cambridge. -----");
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Milan")).forEach(trader -> trader.setCity("Cambridge"));
        System.out.println(transactions);
        System.out.println();

        // Query 7: What's the highest value in all the transactions?
        System.out.println("----- Query 7: What's the highest value in all the transactions? -----");
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(0, Integer::max));

        // Find the transaction with the smallest value
        System.out.println("----- Find the transaction with the smallest value -----");
        Optional<Transaction> smallestTransaction = transactions.stream().min(comparing(Transaction::getValue));
        // Here I cheat a bit by converting the found Transaction (if any) to a String
        // so that I can use a default String if no transactions are found (i.e. the Stream is empty).
        System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
    }
}