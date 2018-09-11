public class Main {
    public static void main(String[] args) {
        
        Item silver = new Item("silver", 2500, 2.0f, 0.002f);
        Item gold = new Item("gold", 3000, 0.3f, 0.025f);
        Item bronze = new Item("bronze", 1800, 0.2f, 0.015f);
        
        Item[] items = {gold, silver, bronze};
        
        System.out.println("max value: " + Rucksack.solve(items, 2.2f));

        System.out.println("max value: " + UnboundedRucksack.solve(items, 25, 0.25f));
    }
}
