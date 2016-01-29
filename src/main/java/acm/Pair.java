package acm;

public class Pair implements Comparable<Pair> {
    private int index;
    private int price;

    public Pair(int index, int price) {
        this.index = index;
        this.price = price;
    }

    public int getPrice() { return this.price; }
    public int getIndex() { return this.index; }

    public int compareTo(Pair other) {
        return this.price - other.price;
    }
}