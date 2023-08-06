package Stack;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements StackInt<E> {
    public static class Node<E> {
        private E data;
        private Node<E> next;

        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        private Node(E dataItem, Node<E> nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    private Node<E> topOfStackRef;

    public LinkedStack() {
        topOfStackRef = null;
    }

    public LinkedStack(E[] data) {
        topOfStackRef = null;
        for (E item : data) {
            push(item);
        }
    }

    @Override
    public E push(E obj) {
        topOfStackRef = new Node(obj, topOfStackRef);
        return obj;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return topOfStackRef.data;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E oldData = topOfStackRef.data;
        topOfStackRef = topOfStackRef.next;
        return oldData;
        //you need to order the processes this way for it to make sense
    }

    @Override
    public boolean isEmpty() {
        return topOfStackRef == null;
    }

    public String toString() {
        StringBuilder r = new StringBuilder();
        Node<E> current = topOfStackRef;
        r.append("[top] <= ");
        while (current != null) {
            r.append(current.data.toString() + " <= ");
            current = current.next;
        }
        r.append("[bottom]");
        return r.toString();
    }
}
