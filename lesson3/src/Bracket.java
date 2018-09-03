public class Bracket {
    
    public static void main(String[] args) {
        check("(()<(<){}<>>>)");
    }
    
    private static void check(CharSequence sequence) {
        int size = sequence.length();
        
        Stack bracket = new Stack(size);
        Stack squareBracket = new Stack(size);
        Stack curlyBracket = new Stack(size);
        Stack angleBracket = new Stack(size);
        
        for (int i = 0; i < sequence.length(); i++) {
            
            char c = sequence.charAt(i);
            
            switch (c) {
                case '(':
                    bracket.push(1);
                    break;
                case '[':
                    squareBracket.push(1);
                    break;
                case '{':
                    curlyBracket.push(1);
                    break;
                case '<':
                    angleBracket.push(1);
                    break;
                    
                case ')':
                    if (bracket.isEmpty()) throw new RuntimeException("wrong syntax");
                    bracket.pop();
                    break;
                case ']':
                    if (squareBracket.isEmpty()) throw new RuntimeException("wrong syntax");
                    squareBracket.pop();
                    break;
                case '}':
                    if (curlyBracket.isEmpty()) throw new RuntimeException("wrong syntax");
                    curlyBracket.pop();
                    break;
                case '>':
                    if (angleBracket.isEmpty()) throw new RuntimeException("wrong syntax");
                    angleBracket.pop();
                    break;
            }
        }
        if (!(bracket.isEmpty() || squareBracket.isEmpty() || curlyBracket.isEmpty() || angleBracket.isEmpty()))
            throw new RuntimeException("wrong syntax");
    }
}
