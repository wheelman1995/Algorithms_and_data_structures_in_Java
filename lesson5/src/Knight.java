public class Knight {
    private static int Y = 8;
    private static int X = 8;
    private static int[][] board = new int[Y][X];
    private static int move = 0;
    private static int curX = -2, curY = -1;
    
    public static void main(String[] args) {
        initBoard();
        knight();
        printBoard();
    }
    
    private static  boolean checkFull() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean checkMove(int curY, int curX, int y, int x) {
        if ((Math.abs(x - curX) == 2 && Math.abs(y - curY) == 1) || (Math.abs(x - curX) == 1 && Math.abs(y - curY) == 2)) {
            return board[y][x] == 0;
        }
        return false;
    }
    
    private static boolean knight() {
        if (checkFull()) return true;
        
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (checkMove(curY, curX, i, j)) {
                    board[i][j] = ++move;
                    int prevY = curY;
                    int prevX = curX;
                    curY = i;
                    curX = j;
                    
//                    printBoard();
//                    System.out.println();
                    if (knight()) return true;
                    
                    move--;
                    board[i][j] = 0;
                    curY = prevY;
                    curX = prevX;
                }
            }
        }
        
        return false;
    }
    
    
    private static void initBoard() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                board[i][j] = 0;
            }
        }
    }
    
    private static void printBoard() {
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                System.out.printf("%3d", board[i][j]);
            }
            System.out.println();
        }
    }
    
}
