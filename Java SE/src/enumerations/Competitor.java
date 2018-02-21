//: enumerated/Competitor.java
// Switching one enum on another.
package enumerations;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
} ///:~
