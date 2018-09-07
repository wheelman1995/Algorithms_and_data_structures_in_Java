import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Relations {
    public static void main(String[] args) {
        RelatedList<Cat> rl = new RelatedList<>();
        rl.insert(new Cat(1, "Barsik"));
        rl.insert(new Cat(2, "Murzik"));
        rl.insert(new Cat(4, "Kissik"));
        System.out.println(rl);
        System.out.println(rl.remove());
        System.out.println(rl);
        System.out.println(rl.contains(new Cat(2, "Murzik")));

        HashMap<String, String> map = new HashMap<>();
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next().getKey() + iter.next().getValue());
        }
    }
}
