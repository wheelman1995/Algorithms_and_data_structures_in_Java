public class TowerOfHanoi {
    private static int[][] tower ={{8,7,6,5,4,3,2,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
    private static int iterations = 0;
    private static int moves = 0;
    
    public static void main(String[] args) {
        printTowers();
        tower(8, tower[0], tower[1], tower[2]);
        System.out.println("iterations: " + iterations);
        System.out.println("moves: " + moves);
    }
    
    private static int findTop(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 0) return i;
        }
        return -1;
    }
    
    private static void tower(int n, int[] src, int[] temp, int[] dst) {
        iterations++;
        if (n == 1) {
            int dstTop = findTop(dst);
            int srcTop = findTop(src);
            dst[dstTop + 1] = src[srcTop];
            src[srcTop] = 0;
            printTowers();
            moves++;
            
        } else {
            tower(n - 1, src, dst, temp);
            tower(1, src, temp, dst);
            tower(n - 1, temp, src, dst);
            
            
        }
        
    
    }
    
    private static void printTowers() {
        for (int i = tower[0].length - 1; i >= 0 ; i--) {
            System.out.println(tower[0][i] + " | " + tower[1][i] + " | " + tower[2][i]);
        }
        System.out.println();
    }
    
}
