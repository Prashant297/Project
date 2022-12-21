package Map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<Integer,String>();
        map.put(101,"Football");
        map.put(102,"Cricket");
        map.put(103,"Basketball");
        map.put(104,"Kabbadi");

        for (Map.Entry m: map.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

    map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(System.out::println);
        }
        }

