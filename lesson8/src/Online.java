public class Online {
    public static void main(String[] args) {
        HashTable ht = new HashTable(25);
        for (int i = 0; i < 11; i++) {
            ht.chainedInsert(new Item(i * 5));
        }
        System.out.println(ht);
        ht.chainedDelete(25);
        System.out.println(ht);
        ht.chainedInsert(new Item(75));
        System.out.println(ht);
    }
}
