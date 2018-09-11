public class Rucksack {
    
    public static int solve(Item[] items, float maxWeight) {
        return solve(items, maxWeight, items.length - 1);
    }
    
    private static int solve(Item[] items, float maxWeight, int n) {
        if (n == -1 || maxWeight == 0)
            return 0;
        
        if (items[n].weight > maxWeight)
            return solve(items, maxWeight, n - 1);
        
        else {
            int temp1 = solve(items, maxWeight, n - 1);
            int temp2 = items[n].value + solve(items, maxWeight - items[n].weight, n - 1);
            
            return Math.max(temp1, temp2);
        }
    }
}
