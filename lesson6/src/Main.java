import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Tree> trees = new ArrayList<>();
        int balancedTrees = 0;
        int numberOfTrees = 1_000_000;

        for (int i = 0; i < numberOfTrees; i++) {
            trees.add(Tree.generateRandomTree());
        }

        for (int i = 0; i < trees.size(); i++) {
            if (trees.get(i).isBalanced())
                balancedTrees++;
        }
    
        System.out.printf("%.2f%% of %d trees are balanced", balancedTrees * 100.0f / numberOfTrees, numberOfTrees);
        
    }
}
