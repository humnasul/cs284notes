public class PairDD {

    public static void main(String [] args) {
        Pair<Integer, String> myPair = new Pair<Integer, String>(4, "Hello");
        System.out.println(myPair.getFirst());
        System.out.println(myPair.getSecond());

        Pair<Double, Integer> secondPair = new Pair<Double, Integer>(4.5,  6);
        System.out.println(secondPair.getFirst());
        System.out.println(secondPair.getSecond());
    }
}
