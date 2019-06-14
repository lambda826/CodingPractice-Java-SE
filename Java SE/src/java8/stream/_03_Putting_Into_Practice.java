package java8.stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import java8.stream.pojo.Trader;
import java8.stream.pojo.Transaction;

public class _03_Putting_Into_Practice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300), 
                new Transaction(raoul, 2012, 1000), 
                new Transaction(raoul, 2011, 400), 
                new Transaction(mario, 2012, 710), 
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // Query 1: Find all transactions in year 2011 and sort them by value (small to high).
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(toList()).forEach(System.out::println);

        // Query 2: What are all the unique cities where the traders work?
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList()).forEach(System.out::println);

        // Query 3: Find all traders from Cambridge and sort them by name.
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct().sorted(comparing(Trader::getName)).collect(toList()).forEach(System.out::println);

        // Query 4: Return a string of all traders' names sorted alphabetically. 
        transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().sorted().reduce((n1, n2) -> n1 + " " + n2).get();

        // Query 5: Are there any trader based in Milan?
        transactions.stream().map(Transaction::getTrader).map(Trader::getCity).anyMatch(city -> city.equals("Milan"));

        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Milan")).forEach(trader -> trader.setCity("Cambridge"));

        // Query 7: What's the highest value in all the transactions?
        transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);

        // Query 8: Find the transaction with the smallest value
        transactions.stream().min(comparing(Transaction::getValue)).map(String::valueOf).orElse("No transactions found");
    }
}