import java.util.Scanner;
import java.util.Stack;

public class RTL {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            CharSequence sequence = scanner.nextLine();
            rtl(sequence);
        }
        
    }
    
    private static void rtl(CharSequence sequence) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < sequence.length(); i++) {
            stack.push(sequence.charAt(i));
        }
    
        while (stack.size() > 0) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}

