/**
  @author: Yunxiang He
  @date  : 2018-07-15 11:51
 */

package containers;

public class _901_CollectionFrameworks {

    // Interface Iterable<T>
    public static void Iterable() {
        // default void forEach(Consumer<? super T> action)
        // Iterator<T> iterator()
        // default Spliterator<T> spliterator()
    }

    // public interface Collection<E> extends Iterable<E>
    public static void Collection() {
        // boolean add(E e)
        // boolean addAll(Collection<? extends E> c)
        // boolean contains(Object o)
        // boolean containsAll(Collection<?> c)
        // boolean remove(Object o)
        // boolean removeAll(Collection<?> c)
        // default boolean removeIf(Predicate<? super E> filter)
        // boolean retainAll(Collection<?> c)
        // void clear()
        // boolean isEmpty()
        // int size()
        // default Stream<E> stream()
        // default Stream<E> parallelStream()
        // Object[] toArray()
        // <T> T[] toArray(T[] a)
        // boolean equals(Object o)
        // int hashCode()
    }

    // public interface List<E> extends Collection<E>
    public static void List() {
        // void add(int index, E element)
        // boolean addAll(int index, Collection<? extends E> c)
        // E get(int index)
        // E set(int index, E element)
        // int indexOf(Object o)
        // int lastIndexOf(Object o)
        // ListIterator<E> listIterator()
        // ListIterator<E> listIterator(int index)
        // default void replaceAll(UnaryOperator<E> operator)
        // default void sort(Comparator<? super E> c)
        // List<E> subList(int fromIndex, int toIndex)
    }

    // ArrayList<E> (implements Cloneable, List<E>, RandomAccess, Serializable)
    public static void ArrayList() {
        // Constructors
        // ArrayList()
        // ArrayList(Collection<? extends E> c)
        // ArrayList(int initialCapacity)

        // Object clone()
        // protected void removeRange(int fromIndex, int toIndex)
        // void ensureCapacity(int minCapacity)
        // void trimToSize()

    }

    // LinkedList<E> (implements Cloneable, Deque<E>, List<E>, Serializable)
    public static void LinkedList() {
        // Constructors
        // LinkedList()
        // LinkedList(Collection<? extends E> c)
    }

    // public interface Set<E> extends Collection<E>
    public static void Set() {

    }

    // HashSet<E> (implements Cloneable, Serializable, Set<E>)
    public static void HashSet() {
        // Constructors
        // HashSet()
        // HashSet(Collection<? extends E> c)
        // HashSet(int initialCapacity)
        // HashSet(int initialCapacity, float loadFactor)
    }

    // public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, Serializable
    public static void LinkedHashSet() {
        // Constructors
        // LinkedHashSet()
        // LinkedHashSet(Collection<? extends E> c)
        // LinkedHashSet(int initialCapacity)
        // LinkedHashSet(int initialCapacity, float loadFactor)
    }

    // public interface SortedSet<E> extends Set<E>
    public static void SortedSet() {
        // E first()
        // E last()
        // Comparator<? super E> comparator()
        // SortedSet<E> headSet(E toElement)
        // SortedSet<E> tailSet(E fromElement)
        // SortedSet<E> subSet(E fromElement, E toElement)
        // Comparator<? super E> comparator()
    }

    // public interface NavigableSet<E> extends SortedSet<E>
    public static void NavigableSet() {
        // E ceiling(E e)
        // E floor(E e)
        // E higher(E e)
        // E lower(E e)
        // E pollFirst()
        // E pollLast()
        // Iterator<E> descendingIterator()
        // NavigableSet<E> descendingSet()
        // NavigableSet<E> headSet(E toElement, boolean inclusive)
        // NavigableSet<E> tailSet(E fromElement, boolean inclusive)
        // NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
    }

    // TreeSet<E> (implements Cloneable, NavigableSet<E>, Serializable)
    public static void TreeSet() {
        // Constructors
        // TreeSet( )
        // TreeSet(Collection<? extends E> c)
        // TreeSet(Comparator<? super E> comparator)
        // TreeSet(SortedSet<E> ss)
    }

    // public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E> implements Cloneable, Serializable
    public static void EnumSet() {
        // static <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType)
        // EnumSet<E> clone()
        // static <E extends Enum<E>> EnumSet<E> complementOf(EnumSet<E> s)
        // static <E extends Enum<E>> EnumSet<E> copyOf(Collection<E> c)
        // static <E extends Enum<E>> EnumSet<E> copyOf(EnumSet<E> s)
        // static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType)
        // static <E extends Enum<E>> EnumSet<E> of(E e)
        // static <E extends Enum<E>> EnumSet<E> of(E first, E... rest)
        // static <E extends Enum<E>> EnumSet<E> of(E e1, E e2)
        // static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3)
        // static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4)
        // static <E extends Enum<E>> EnumSet<E> of(E e1, E e2, E e3, E e4, E e5)
        // static <E extends Enum<E>> EnumSet<E> range(E from, E to)
    }

    // public interface Queue<E> extends Collection<E>
    public static void Queue() {
        // boolean offer(E e)
        // E element()
        // E peek() -- returns null if the list is empty
        // E remove()
        // E poll() -- returns null if the list is empty
    }

    // public interface Deque<E> extends Queue<E>
    public static void Deque() {
        // E pop()
        // void push(E e)
        // void addFirst(E e)
        // void addLast(E e)
        // boolean offerFirst(E e)
        // boolean offerLast(E e)
        // E getFirst()
        // E getLast()
        // E peekFirst()
        // E peekLast()
        // E pollFirst()
        // E pollLast()
        // E removeFirst()
        // E removeLast()
        // boolean remove(Object o)
        // boolean removeFirstOccurrence(Object o)
        // boolean removeLastOccurrence(Object o)
        // boolean descendingIterator()
    }

    // public class ArrayDeque<E> extends AbstractCollection<E> implements Deque<E>, Cloneable, Serializable
    public static void ArrayDeque() {
        // Constructors
        // ArrayDeque()
        // ArrayDeque(Collection<? extends E> c)
        // ArrayDeque(int numElements)
    }

    // public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable
    public static void PriorityQueue() {
        // Constructors
        // PriorityQueue()
        // PriorityQueue(Collection<? extends E> c)
        // PriorityQueue(Comparator<? super E> comparator)
        // PriorityQueue(int initialCapacity)
        // PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        // PriorityQueue(PriorityQueue<? extends E> c)
        // PriorityQueue(SortedSet<? extends E> c)
    }

    // public interface Iterator<E>
    public static void Iterator() {
        // boolean hasNext()
        // E next()
        // void remove()
        // default void forEachRemaining(Consumer<? super E> action)
    }

    // public interface ListIterator<E> extends Iterator<E>
    public static void ListIterator() {
        // nextIdex()
        // previous()
        // hasPrevious()
        // previousIndex()
        // void add(E e)
        // void set(E e)
    }

    // public interface Spliterator<T>
    public static void Spliterator() {
        // int characteristics()
        // long estimateSize()
        // default void forEachRemaining(Consumer<? super T> action)
        // default Comparator<? super T> getComparator()
        // default long getExactSizeIfKnown()
        // default boolean hasCharacteristics(int characteristics)
        // boolean tryAdvance(Consumer<? super T> action)
        // Spliterator<T> trySplit()
    }

    public static void main(String[] args) {
        _901_CollectionFrameworks.HashSet();
    }
}
