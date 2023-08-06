public class Test {

    public static void main(String[] args) {
        A x;
        x = new B();
        System.out.println(x.m(5));
        //calls method from B
        System.out.println(((B) x).testB());
    }
}
