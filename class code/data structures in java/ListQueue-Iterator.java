/*<listing chapter="4" number="12">*/
package KW.CH04;

import java.util.Queue;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements the Queue interface using a single-linked list.
 * @param <E> the element type
 * @author Koffman and Wolfgang
 **/
public class ListQueue<E> extends AbstractQueue<E>
        implements Queue<E> {

    // Data Fields
    /** Reference to front of queue. */
    private Node<E> front;
    /** Reference to rear of queue. */
    private Node<E> rear;
    /** Size of queue. */
    private int size;

    // Insert inner class Node<E> here (see Listing 2.1)
    /** A Node is the building block for a single-linked list. */
    private static class Node<E> {
        // Data Fields

        /** The reference to the data. */
        private final E data;
        /** The reference to the next node. */
        private Node<E> next;

        // Constructors
        /**
         * Creates a new node with a null next field.
         * @param dataItem The data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    } //end class Node
    
    // Constructors
    public ListQueue() {
        super();
        front = null;
        rear = null;
        size = 0;
    }
  
    public ListQueue(Collection<E> c) {
        this();
        c.forEach(item -> offer(item));
    }

    // Methods
    /**
     * Insert an item at the rear of the queue.
     * postitem is added to the rear of the queue.
     * @param item The element to add
     * @return true (always successful)
     */
    @Override
    public boolean offer(E item) {
        // Check for empty queue.
        if (front == null) {
            rear = new Node<>(item);
            front = rear;
        } else {
            // Allocate a new node at end, store item in it, and
            // link it to old end of queue.
            rear.next = new Node<>(item);
            rear = rear.next;
        }
        size++;
        return true;
    }

    /**
     * Remove the entry at the front of the queue and return it
     * if the queue is not empty.
     * postfront references item that was second in the queue.
     * @return The item removed if successful, or null if not
     */
    @Override
    public E poll() {
        E item = peek(); // Retrieve item at front.
        if (item == null) {
            return null;
        }
        // Remove item at front.
        front = front.next;
        size--;
        return item; // Return data at front of queue.
    }

    /**
     * Return the item at the front of the queue without removing it.
     * @return The item at the front of the queue if successful;
     * return null if the queue is empty
     */
    @Override
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return front.data;
        }
    }

    /*<exercise chapter="4" section="7" type="programming" number="1">*/
    /**
     * Returns the size of the queue
     * @return the size of the queue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator to the contents of this queue
     * @return an iterator to the contents of this queue
     */
    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    /**
     * Inner class to provide an iterator to the contents of
     * the queue.
     */
    private class Iter implements Iterator<E> {

        Node<E> next = front;

        /**
         * Returns true if there are more elements in the iteration
         * @return true if there are more elements in the iteration
         */
        @Override
        public boolean hasNext() {
            return next != null;
        }

        /**
         * Return the next item in the iteration and advance the iterator
         * @return the next item in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            E item = next.data;
            next = next.next;
            return item;
        }

        /**
         * Removes the last item returned by this iteration
         * @throws UnsupportedOperationException this operation is not
         * supported
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    /*</exercise>*/

    /*<exercise chapter="4" type="ReviewQuestion" number="10">*/
    /**
     * Move the element currently at the front of the queue to the rear
     * of the queue. Does nothing if the queue is empty or has only one
     * item.
     */
    public void moveToRear() {
        if (size == 0 || size == 1) {
            return;
        }
        Node<E> oldFront = front;
        front = front.next;
        rear.next = oldFront;
        rear = rear.next;
    }
    /*</exercise>*/
    
    /*<exercise chapter="4" type="ReviewQuestions" number="13">*/
    /**
     * Move the element currently at the rear of the queue to the front
     * of the queue. Does nothing if the queue is empty or has only one 
     * item.
     */
    public void moveToFront() {
        if (size == 0 || size == 1) {
            return;
        }
        Node<E> oldRear = rear;
        Node<E> current = front;
        while (current.next != rear) {
            current = current.next;
        }
        current.next = null;
        rear = current;
        oldRear.next = front;
        front = oldRear;  
    }
	/*</exercise>*/

}
/*</listing>*/
