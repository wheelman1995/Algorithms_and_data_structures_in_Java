import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class DoubleLinkedList<T> extends RelatedList {
    private class Node<T> {
        T c;
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
        
        Node<T> prev;
        Node<T> next;
    }
    
    private Node<T> head;
    private Node<T> iterNext;
    
    public DoubleLinkedList() {
        head = null;
        iterNext = head;
    }
    
    
    @Override
    public void insert(Object c) {
        Node<T> n = new Node<T>((T)c);
        n.next = head;
        if (head != null) {
            head.prev = n;
        }
        head = n;
        iterNext = head;
    }
    
    
    public T delete(T c) {
        Node<T> current = head;
        
        while (!current.c.equals(c)) {
            if (current.next == null)
                return null;
            
            current = current.next;
            
        }
        if (current == head) {
            head = head.next;
            iterNext = head;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return current.c;
    }
    
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public T remove() {
        if (isEmpty())
            return null;
        T temp = head.c;
        head = head.next;
        iterNext = head;
        return temp;
    }
    
    @Override
    public boolean contains(Object c) {
        Node<T> n = new Node<>((T) c);
        Node<T> current = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
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
        return iterNext != null;
    }
    
    public T next() {
        Node<T> toBeReturned = iterNext;
        iterNext = iterNext.next;
        return toBeReturned.c;
    }
}
