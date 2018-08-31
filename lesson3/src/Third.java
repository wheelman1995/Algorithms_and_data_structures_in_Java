package jads.three.online;

public class Third {
    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        while (!s.isEmpty()) {
            System.out.print("pop=" + s.pop() + " ");
        }
        System.out.println();
        s.push(5);
        s.push(6);
        System.out.println("peek="+s.peek());

    }
}
