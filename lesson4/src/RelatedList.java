import java.util.Objects;

public class RelatedList<T> {
    private class Node<T> {
        T c;
        Node<T> next;
        public Node(T c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return c.toString();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<T> node = (Node) o;
            return Objects.equals(c, node.c);
        }
    }

    private Node<T> head;
    private Node<T> nextItem;

    public RelatedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T c) {
        Node<T> n = new Node<>(c);
        n.next = head; // if (head == null) n.next = null;
        head = n;
    }

    public T find(T t) {
        Node<T> n = new Node<>(t);
        Node<T> current = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return null;
            current = current.next;
        }
        return current.c;
    }
    
    public T remove() {
        if (isEmpty())
            return null;
        T temp = head.c;
        head = head.next;
        return temp;
    }

    public boolean contains(T c) {
        Node<T> n = new Node<>(c);
        Node<T> current = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }
    
    public T delete(T t) {
        Node<T> current = head;
        Node<T> previous = head;
        while (!current.c.equals(t)) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head)
            head = head.next;
        else
            previous.next = current.next;
        
        return current.c;
    }
    
    public T delete(String name) {
        Node<T> current = head;
        Node<T> previous = head;
        while (!(((Cat)current.c).getName()).equals(name)) {
            if (current.next == null)
                return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head)
            head = head.next;
        else
            previous.next = current.next;

        return current.c;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> current = head;
        StringBuilder sb = new StringBuilder("[");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? "]" : ", ");
        }
        return sb.toString();
    }
    
    public boolean hasNext() {
        if (head == null)
            return false;
        if (nextItem == null)
            return true;
        return nextItem.next != null;
    }
    
    public T next () {
        if (nextItem == null) {
            nextItem = head;
            return nextItem.c;
        }
        nextItem = nextItem.next;
        return nextItem.c;
    }
}
