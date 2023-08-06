import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
        public static void main(String[] args) {
            List<String> myList = new ArrayList<String>();
            myList.add("Bashful");
            myList.add("Awful");
            myList.add("Jumpy");
            myList.add("Happy");

            System.out.println(myList);

            for(String element: myList)
                System.out.println(element);
            //if you have a single line statement after for loop, you do not need curly braces

            myList.add(2, "Grumpy");
            System.out.println(myList);

            myList.remove(3);
            System.out.println(myList);

            myList.set(1, "Funny");
            System.out.println(myList);

            System.out.println(myList.get(1));
            System.out.println(myList.indexOf("Funny"));
        }
}
