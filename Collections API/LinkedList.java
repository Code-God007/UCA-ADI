import java.util.Iterator;

public class LinkedList implements Iterable<Integer> {

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.insert(1);
        l.insert(2);
        l.insert(3);
        l.insert(4);
        l.insert(5);

        for (int i : l) {
            System.out.println(i);
        }

        // Same as above
        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    private Node first;

    public void insert(int key) {
        first = insert(first, key);
    }

    private Node insert(Node n, int key) {
        if (n == null)
            return new Node(key);
        n.next = insert(n.next, key);
        return n;
    }

    private class Node {

        private int key;
        private Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Integer> {
        private Node temp = first;

        @Override
        public boolean hasNext() {
            return temp != null;
        }

        @Override
        public Integer next() {
            int t = temp.key;
            temp = temp.next;
            return t;
        }
    }

}