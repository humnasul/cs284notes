package Queues;

import java.util.AbstractQueue;
import java.util.Queue;

public class ListQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private static class Node<E> {

    private E data;
    private ListQueue.Node<E> next;

    private Node(E dataItem) {
        data = dataItem;
        next = null;
    }

    private Node(E dataItem, ListQueue.Node<E> nodeRef) {
        data = dataItem;
        next = nodeRef;
    }
}

    private Node<E> front; // front of queue
    private Node<E> rear; // end of queue
    private int size;

    @Override
    public E peek() {
        if (size == 0) { // front == null
            return null;
        }
        //cannot do if (first.data == null) because the data itself does not exist (null)
        return front.data;
    }

    @Override
    public boolean offer(E item) {
        if (item == null) {
            return false;
        }
        if (front == null) {
            rear = new Node<>(item);
            front = rear;
        }
        else {
            rear.next = new Node<E>(item);
            rear = rear.next;
        }
        size++;
        return true;

    }

    /**
     * poll method removes the first element of a queue and returns its data
     * It returns null when the queue is empty
     * @return null (if empty), otherwise front.data
     */
    public E poll() {
        E item = peek();
        if (item == null) {
            return null;
        }
        if (size == 1) {
            front = null;
            rear = null;
        }
        else {
            front = front.next;
        }
        return item;
    }
}