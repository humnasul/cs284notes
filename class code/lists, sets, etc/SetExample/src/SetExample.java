import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        String[] listA = {"Ann", "Jill", "Sally", "Sally"};
        String[] listB = {"Ann", "Jill", "Bill", "Bob"};
        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();
        Set<String> setAcopy = new HashSet<>();

        for(String s : listA) {
            setA.add(s);
            setAcopy.add(s);
        }
        for (String s: listB) {
            setB.add(s);
        }

        System.out.println(setA);
        System.out.println(setB);
        System.out.println(setA.addAll(setB));
        System.out.println(setA);
        System.out.println(setAcopy.retainAll(setB));
        System.out.println(setAcopy);

        /*
        Hashmap example
         */
    }
}
