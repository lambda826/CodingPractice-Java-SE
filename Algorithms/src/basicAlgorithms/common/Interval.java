/**
 *    Copyright 2017 Yunxiang He
 *
 *    All right reserved.
 * 
 *    Create on Oct 23, 2017 5:19:57 PM
 */
package basicAlgorithms.common;

/**
 * @author Yunxiang He
 * @date Oct 23, 2017 5:19:57 PM
 */
public class Interval implements Comparable<Interval> {

    private String name;
    private int start;
    private int end;
    private int weight;

    public Interval(String name, int start, int end, int weight) {
        super();
        this.name = name;
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Interval o) {
        return this.end - o.end;
    }
}
