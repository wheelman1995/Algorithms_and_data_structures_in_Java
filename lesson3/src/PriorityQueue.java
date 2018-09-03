import java.util.Arrays;

public class PriorityQueue {
    private int size;
    private int head;
    private int tail;
    private int items;
    private int[] priorityQueue;
    
    public PriorityQueue(int size) {
        this.size = size;
        head = 0;
        tail = -1;
        items = 0;
        priorityQueue = new int[size];
    }
    
    public boolean isFull() {
        return items == size;
    }
    
    public boolean isEmpty() {
        return items == 0;
    }
    
    public int size() {
        return items;
    }
    
    public void insert(int value) {
        
        if (isFull()) {
            size *=2;
            int[] temp = new int[size];
            
            if (head <= tail) {
                System.arraycopy(priorityQueue, 0, temp, 0, priorityQueue.length);
            } else if (head > tail) {
                System.arraycopy(priorityQueue, head, temp, size - (priorityQueue.length - head), priorityQueue.length - head);
                System.arraycopy(priorityQueue, 0, temp, 0, tail + 1);
                head = size - (priorityQueue.length - head);
            }
            priorityQueue = temp;
        }
        
        int index = head;
        if (head <= tail) {
            int n = tail - head + 1;
            while (value > priorityQueue[index] && n > 0) {
                index++;
                n--;
            }
        } else if(head > tail) {
            int n = size - head + tail + 1;
            while (value > priorityQueue[index] && n > 0) {
                index++;
                index %= size;
                n--;
            }
        }
    
        int elementsToBeShifted = 0;
        
        if (index >= head) {
            elementsToBeShifted = items - (index - head);
        } else if (index < head) {
            if (index <= tail) {
                elementsToBeShifted = tail - index + 1;
            } else {
                elementsToBeShifted = 0;
            }
        }
        for ( ; elementsToBeShifted > 0  ; elementsToBeShifted--) {
            priorityQueue[(index + elementsToBeShifted) % size] = priorityQueue[(index + elementsToBeShifted - 1) % size];
        }
        
        priorityQueue[index] = value;
        tail++;
        tail %= size;

        items++;
    
        System.out.println(Arrays.toString(priorityQueue) + "head " + head + " tail " + tail);
    }
    
    public int remove() {
        if (isEmpty())
            throw new RuntimeException();
        int temp = priorityQueue[head++];
        head %= size;
        items--;
        System.out.println(Arrays.toString(priorityQueue) + "head " + head + " tail " + tail);
        return temp;
    }
    
    public int peek() {
        if (isEmpty())
            throw new RuntimeException();
        return priorityQueue[head];
    }
}
