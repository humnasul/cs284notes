public class Pair<E, F> {
    private E first;
    private F second;

    Pair(E fst, F snd) {
        //default access modifier, package private
        //only accessible within package
        first = fst;
        second = snd;
    }

    public E getFirst(){ return first; }

    public void setFirst(E fst){ first = fst;}

    public F getSecond(){ return second; }

    public void setSecond(F second) { this.second = second; }

    @Override
    public String toString() {
        return first.toString() + ", " + second.toString();
    }
}
