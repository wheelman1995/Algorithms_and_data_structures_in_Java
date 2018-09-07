import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Relations {
    public static void main(String[] args) {
        DoubleLinkedList<Cat> dll = new DoubleLinkedList<>();
        Cat c = new Cat(2, "Murzik");
        dll.insert(new Cat(1, "Barsik"));
        dll.insert(c);
        dll.insert(new Cat(4, "Kissik"));
//        System.out.println(dll);
//        System.out.println(dll.delete(c));
//        System.out.println(dll);
//        System.out.println(dll.contains(new Cat(2, "Murzik")));
        

//        HashMap<String, String> map = new HashMap<>();
//        Set<Map.Entry<String, String>> set = map.entrySet();
//        Iterator<Map.Entry<String, String>> iter = set.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next().getKey() + iter.next().getValue());
//        }
        
        dll.insert(c);
        
        while (dll.hasNext()) {
            System.out.println(dll.next());
        }
    }
}
