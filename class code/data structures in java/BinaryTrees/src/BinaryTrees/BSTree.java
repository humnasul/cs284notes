package BinaryTrees;

public class BSTree<Key extends Comparable<Key>, Value> {
    private Node root;
    public class Node {
        //can also be static - in general, this class should be private but for learning it is public
        private Key key;
        /*in real life, key would be an identifer of the Node (value), but for our learning
        she has decided to use key! */
        private Value value;
        private Node left;
        private Node right;
        private int size;
        public Node() {
            key = null;
            value = null;
            left = null;
            right = null;
            size = 0;
        }

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
            left = null;
            right = null;
        }
    }

    public Node inorder() {
        return inorder(root);
    }

    public Node preorder() {
        return preorder(root);
    }

    private Node inorder(Node search) {
        if (search != null) {
            inorder(search.left);
            System.out.println(search.key);
            inorder(search.right);
        }
        return search;
    }

    private Node preorder(Node search) {
        if (search != null) {
            System.out.println(search.key);
            preorder(search.left);
            preorder(search.right);
        }
        return search;
    }

    public Node search(Key key) {
        return search(key, root);
    }

    public Node search(Key key, Node x) {
        if (key == null) {
            throw new IllegalArgumentException("Searched item is null!");
        }
        if (x == null || key.compareTo(x.key) == 0) {
            return x;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return search(key, x.left);
        }
        if (compare > 0) {
            return search(key, x.right);
        }
        return x;
        //you can also use an else and return x
    }

    public void insert(Key key, Value value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Insert: Key/Value is null!");
        }
        root = insert(root, key, value);
    }

    private Node insert(Node x, Key key, Value value) {
        if (x == null) {
            x = new Node(key, value, 1);
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = insert(x.left, key, value);
        }
        if (compare > 0) {
            x.right = insert(x.right, key, value);
        }
        x.size = 1 + size(x.left) + size(x.right);
    }

    public Node min(Node x) {
        if (x.left == null ) {
            return x;
        }
        else return min(x.left);
    }

    public Node successor(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Successor: Key null!");
        }
        return successor(root, key);
    }

    public Node successor(Node node, Key key) {

    }

    public int size(Node x) {return size(root);}

    public int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMn(Node x) {

    }

    public void delete (Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Delete: Key is null");
        }
        root = delete(root,key);
    }

    public Node delete(Node x, Key key) {
        if(x == null) {
            return null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = delete(x.left, key);
        }
        else if (compare > 0) {
            x.right = delete(x.right, key);
        }
        //does not matter to check left or right first
        else {
            if (x.right == null) {
                return x.left;
            }
            else if (x.left == null) {
                return x.right;
            }

            Node temp = x;
            x = min(x.right);
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        x.size = size(x.left) + size(x.right) +1;
        return x;
    }

}
