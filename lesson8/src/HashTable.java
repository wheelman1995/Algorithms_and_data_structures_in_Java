public class HashTable {
    private Item[] hashArr;
    private RelatedList<Item>[] chainedHashTable;
    private int arrSize;
    private Item nullItem;

    public HashTable(int arrSize) {
        this.arrSize = arrSize;
        hashArr = new Item[arrSize];
        nullItem = new Item(-1);
        chainedHashTable = new RelatedList[arrSize];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            sb.append((chainedHashTable[i] != null) ? chainedHashTable[i] : "*");
            if (i < arrSize - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private int hashFunc(int key) {
        return key % arrSize;
    }

    public void chainedInsert(Item item) {
        int key = item.getKey();
        int hash = hashFunc(key);
        if (chainedHashTable[hash] == null)
            chainedHashTable[hash] = new RelatedList<>();
        chainedHashTable[hash].insert(item);
    }
    
    public void insert(Item item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
//        int step = 0;
        int step = dblHashFunc(key);
        while (hashArr[hashVal] != null &&
                hashArr[hashVal] != nullItem) {
//            hashVal = linearProbe(hashVal);

//            step++;
//            hashVal = quadProbe(hashVal, step);
            
            hashVal += step;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item chainedFind(int key) {
        int hash = hashFunc(key);
        while (chainedHashTable[hash].hasNext()) {
            Item item = chainedHashTable[hash].next();
            if (item.getKey() == key)
                return item;
        }
        return null;
    }
    
    public Item find(int key) {
        int hashVal = hashFunc(key);
//        int step = 0;
        int step = dblHashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key)
                return hashArr[hashVal];
//            hashVal = linearProbe(hashVal);

//            step++;
//            hashVal = quadProbe(hashVal, step);

            hashVal += step;
            hashVal %= arrSize;
        }
        return null;
    }
    int dblHashFunc(int key) {
        return  19 - (key % 19);
    }

    public Item chainedDelete(int key) {
        int hash = hashFunc(key);
        while (chainedHashTable[hash].hasNext()) {
            Item item = chainedHashTable[hash].next();
            if (item.getKey() == key)
                return chainedHashTable[hash].delete(item);
        }
        return  null;
    }
    
    public Item delete(int key) {
        int hashVal = hashFunc(key);
//        int step = 0;
        int step = dblHashFunc(key);
        while (hashArr[hashVal] != null) {
            if (hashArr[hashVal].getKey() == key) {
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nullItem;
                return temp;
            }
//            hashVal = linearProbe(hashVal);

//            step++;
//            hashVal = quadProbe(hashVal, step);

            hashVal += step;
            hashVal %= arrSize;
        }
        return null;
    }

    private int linearProbe(int hashVal) {
        hashVal++;
//        if (hashVal == arrSize) hashVal = 0;
        hashVal %= arrSize;
        return hashVal;
    }

    private int quadProbe(int hashVal, int step) {
        hashVal += step * step;
        hashVal %= arrSize;
        return hashVal;
    }

    private boolean isFull() {
        for (int i = 0; i < hashArr.length; i++) {
            if (hashArr[i] == null || hashArr[i] == nullItem)
                return false;
        }
        return true;
    }
}
