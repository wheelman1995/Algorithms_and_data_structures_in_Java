public class Deque {
    private int size;
    private int items;
    private int[] deque;
    private int left;
    private int right;
    
    public Deque(int size) {
        this.size = size;
        items = 0;
        deque = new int[size];
        left = -1;
        right = size;
    }
    
    public void attachLeft(int value) {
        if (isFull()) {
            size *= 2;
            int[] temp = new int[size];
            if (left > -1) {
                System.arraycopy(deque, 0, temp, 0, left + 1);
            }
            if (right < deque.length) {
                System.arraycopy(deque, right, temp, size - (deque.length - right), deque.length - right);
            }
            right = size - (deque.length - right);
            deque = temp;
        }
        deque[++left] = value;
        items++;
    }
    
    public void attachRight(int value) {
        if (isFull()) {
            size *= 2;
            int[] temp = new int[size];
    
            if (left > -1) {
                System.arraycopy(deque, 0, temp, 0, left + 1);
            }
            if (right < deque.length) {
                System.arraycopy(deque, right, temp, size - (deque.length - right), deque.length - right);
            }
            right = size - (deque.length - right);
            deque = temp;
        }
        deque[--right] = value;
        items++;
    }
    
    public int removeLeft() {
        if (isEmpty() || left == -1)
            throw new RuntimeException();
        items--;
        return deque[left--];
    }
    
    public int removeRight() {
        if (isEmpty() || right == size)
            throw new RuntimeException();
        items--;
        return deque[right++];
    }
    
    public boolean isFull() {
        return items == size;
    }
    
    public boolean isEmpty() {
        return items == 0;
    }
    
    public int peekLeft() {
        if (isEmpty() || left == -1)
            throw new RuntimeException();
        return deque[left];
    }
    
    public int peekRight() {
        if (isEmpty() || right == size)
            throw new RuntimeException();
        return deque[right];
    }
}

