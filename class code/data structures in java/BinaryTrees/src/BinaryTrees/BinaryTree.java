package BinaryTrees;
public class BinaryTree<E extends Comparable<E>> {

    public class Node{
        // data fields
        private E data;
        private Node left;
        private Node right;

        public Node(E data, Node left, Node right) {
            super();
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(E data) {
            super();
            this.data = data;
        }


    }

    // data fields
    private Node root;
    private int size;

    BinaryTree() {
       //TO-DO
    }

    BinaryTree(E data) {
        root = new Node(data);
        size = 1;
    }

    BinaryTree(Node node){
        root = node;
        //write method to calculate size here.
    }

    public BinaryTree(E data, BinaryTree<E> leftTree,
                      BinaryTree<E> rightTree) {
        root = new Node(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        }
        else {
            root.left = null;
        }

        if (rightTree != null) {
            root.right = rightTree.root;
        }
        else {
            root.right = null;
        }

    }

    /**
     * Determine whether this tree is a leaf.
     *
     * @return true if the root has no children
     */
    public boolean isLeaf() {
        //TO-DO
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return false;
    }

    /**
     * Return the left subtree.
     *
     * @return The left subtree or null if either the root or the left subtree
     * is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root == null || root.left == null) {
            return null;
        }
        else {
            return new BinaryTree<>(root.left);
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or null if either the root or the right
     * subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root == null || root.right == null) {
            return null;
        }
        else {
            return new BinaryTree<>(root.right);
        }
    }

    private int height(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + Math.max(height(current.left), height(current.right));
    }

    public int height() {
        return height(root);
    }

    private int getLevel(Node node, E data, int level) {
        //TO-DO
        if (node == null) {
            return 0;
            //empty node or node does not exist in tree
        }
        if (node.data.compareTo(data) == 0) {
            return level;
        }
        //compareTo is used because of the generic type - compareTo works with diff data types
        int downLevel = getLevel(node.left, data, level+1);
        if (downLevel != 0) {
            return downLevel;
        }
        downLevel = getLevel(node.right, data, level +1);
        return downLevel;
    }

    public int getLevel(E data) {
        return getLevel(root, data, 1);
    }

    private String toString(Node current, int level){
        // TO-DO
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < level; i++) {
            s.append("-");
        }
        if (current == null) {
            s.append("null\n");
        }
        else {
            s.append(current.data.toString() + "\n");
            s.append(toString(current.left, level + 1));
            s.append(toString(current.right, level + 1));
        }
        return s.toString();

    }


    public String toString() {
        return toString(root, 0);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> t1 = new BinaryTree<>(7,new BinaryTree<>(), new BinaryTree<>());
        BinaryTree<Integer> t2 = new BinaryTree<>(33,new BinaryTree<>(27,new BinaryTree<>(), new BinaryTree<>()),new BinaryTree<>());
        BinaryTree<Integer> t3 = new BinaryTree<>(23,t1,t2);

        System.out.println(t3);
        System.out.println(t3.height());
        System.out.println(t3.getLevel(33));
    }
}
