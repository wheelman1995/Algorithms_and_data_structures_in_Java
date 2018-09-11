public class UnboundedRucksack {
    
    public static int solve(Item[] items, int maxWeight, float maxVolume) {
        return solve(items, maxWeight, maxVolume, items.length - 1);
    }
    
    private static int solve(Item[] items, float maxWeight, float maxVolume, int n) {
        if (n == -1 || maxWeight <= 0 || maxVolume <= 0)
            return 0;
        
        
        if (items[n].weight > maxWeight || items[n].volume > maxVolume)
            return solve(items, maxWeight, maxVolume, n - 1);
        
        else {
            int temp1 = solve(items, maxWeight, maxVolume, n - 1);
            int temp2 = items[n].value + solve(items, maxWeight - items[n].weight, maxVolume - items[n].volume, n);
            int temp3 = items[n].value + solve(items, maxWeight - items[n].weight, maxVolume - items[n].volume, n - 1);
            
            return Math.max(temp1, Math.max(temp2, temp3));
        }
    }
}


