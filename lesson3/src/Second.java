public class Second {
    public static void main(String[] args) {
        Array arr = new Array(20);
        arr.append(1); arr.append(7);
//        arr.append(-5); arr.append(2);
//        arr.append(7); arr.append(3);
//        arr.append(7); arr.append(0);
//        System.out.println(arr);
//        arr.deleteAll(7);
//        arr.pigeon();
//        System.out.println(arr);
        arr.delete(2); //в вашем методе delete вываливается exception, если удалять последний элемент массива
        System.out.println(arr);
        
        
        Deque deque = new Deque(2);
        deque.attachLeft(1);
        deque.attachLeft(5);

        deque.attachRight(2);
        deque.attachRight(11);
        deque.attachRight(12);
        deque.attachRight(13);
        deque.attachRight(14);
        deque.attachRight(15);
        deque.attachRight(16);
        deque.attachRight(17);
        deque.attachRight(18);
        System.out.println("removeRigh t" + deque.removeRight());
        System.out.println("removeLeft " + deque.removeLeft());
        System.out.println(deque.peekLeft());
        System.out.println(deque.peekRight());
        
        PriorityQueue priorityQueue = new PriorityQueue(1);
        priorityQueue.insert(4);
        priorityQueue.insert(5);
        priorityQueue.insert(0);
        priorityQueue.insert(-1);
        priorityQueue.insert(-1);
        
        priorityQueue.remove();
        priorityQueue.remove();
        priorityQueue.remove();
        priorityQueue.remove();
        
        priorityQueue.insert(100);
        priorityQueue.insert(101);
        priorityQueue.insert(103);
        priorityQueue.insert(88);
        priorityQueue.insert(10670);
        priorityQueue.insert(44);
        priorityQueue.insert(-44);
    }
}
