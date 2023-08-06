import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

public class KWArrayList<E>  extends AbstractList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private E[] theData;
    private int size = 0;
    private int capacity = 0;

    public KWArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    public KWArrayList(int capacity) {
        this.capacity = capacity;
        theData = (E[]) new Object[capacity];
    }

    public KWArrayList(Collection<? extends E> c) {
        this.addAll(c);
    }

    @Override
    public boolean add(E anEntry) {
        if(size == capacity) {
            //reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    public void add(int index, E anEntry) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: "+index);
        }
        if (size == capacity) {
            //reallocate();
        }
        for (int i = size; i > index; i--) {
            theData[i] = theData[i-1];
        }
        theData[index] = anEntry;
        size++;
    }

    /**
     * This method will return the element in the given index
     * @param index index of the element to return
     * @return type E return,
     */
    @Override
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: "+index);
        }
        return theData[index];
    }

    @Override
    public E set(int index, E anEntry) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: "+index);
        }
        E oldValue = theData[index];
        theData[index] = anEntry;
        return oldValue;
    }

    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Wrong index: "+index);
        }
        E oldValue = theData[index];
        for (int i = index + 1; index < size; i++ ) {
            theData[i - 1] = theData[i];
        }
        return oldValue;
    }

    private void reallocate() {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (theData[i] == null && item == null) {
                return i;
            }
            if (theData[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
}
