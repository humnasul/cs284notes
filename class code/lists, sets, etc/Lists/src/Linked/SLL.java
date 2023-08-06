package Linked;

public class SLL<E>{
    public static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E dataItem) {
            data = dataItem;
            next = null;
        }

        public Node (E dataItem, Node<E> next) {
            data = dataItem;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;
    public void add(E item, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add: Index out of bounds!");
        }
        if (index == 0) {
            addFirst(item);
        }
    }

}
