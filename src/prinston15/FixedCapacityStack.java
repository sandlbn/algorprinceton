package prinston15;

/**
 * Created by sand on 10/09/14.
 */
public class FixedCapacityStack<Item> {
    private Item[] a; //stack entries
    private int N; //size

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        FixedCapacityStack<String> s;
        s = new FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (! item.equals('-')) {
                s.push(item);
            } else if (!s.isEmpty()) {
                StdOut.print(s.pop() + "  ");
            }
        }
        StdOut.println("" + s.size() + "left on stack");
    }

}
