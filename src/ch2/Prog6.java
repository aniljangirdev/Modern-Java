package ch2;

import java.util.Iterator;
import java.util.Set;

public class Prog6 {
    public static void main(String[] args) {
        Set<String> strings = Set.of("test", "test1");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
