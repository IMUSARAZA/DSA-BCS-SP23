class Node4 {
    int key;
    Node4 left, right;

    public Node4(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    Node4 root;

    BinaryTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node4 insertRec(Node4 root, int key) {
        if (root == null) {
            root = new Node4(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node4 deleteRec(Node4 root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node4 root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node4 root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node4 root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder() {
        postorderRec(root);
    }

    void postorderRec(Node4 root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    public boolean isAVLTree() {
        return isAVLTree(root);
    }

    private boolean isAVLTree(Node4 root) {
        if (root == null)
            return true;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int balanceFactor = leftHeight - rightHeight;

        if (balanceFactor > 1 || balanceFactor < -1)
            return false;

        return isAVLTree(root.left) && isAVLTree(root.right);
    }

    private int getHeight(Node4 node) {
        if (node == null)
            return 0;

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorder();

        System.out.println("\n\nPreorder traversal");

        tree.preorder();

        System.out.println("\n\nPostorder traversal:");
        tree.postorder();

        System.out.println("\n\nAfter deleting 20:");
        tree.delete(20);
        tree.inorder();

        System.out.println("\n\nIs AVL Tree: " + tree.isAVLTree());
    }
}

