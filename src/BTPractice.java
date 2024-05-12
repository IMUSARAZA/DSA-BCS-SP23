import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node3{
    int data;
    Node3 left;
    Node3 right;

    public Node3(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BTPractice {
    static int index = -1;
    public static Node3 buildTree(int[] Nodes) {
        index++;
        if (Nodes[index] == -1) {
            return null;
        }
        Node3 newNode = new Node3(Nodes[index]);
        newNode.left = buildTree(Nodes);
        newNode.right = buildTree(Nodes);

        return newNode;
    }

    public static void preOrder(Node3 root){
        if(root == null) return;

        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node3 root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data+" ");
    }

    public static void inOrder(Node3 root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }

    public static void breadthFirst(Node3 root){ // also called level order traversal

        if(root == null)
            return;
        Queue<Node3> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node3 current = q.remove();
            if(current == null){
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                System.out.print(current.data+ " ");
                if(current.left != null)
                    q.add(current.left);
                if(current.right != null)
                    q.add(current.right);
            }
        }
    }

    public static int heightOfTree(Node3 root){ // same as breadth first, we are just not printing data
        int count = 0;
        if(root == null)
            return 0;
        Queue<Node3> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node3 current = q.remove();
            if(current == null){
                count++;                // counter is added instead of printing data
                //System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                //System.out.print(current.data+ " ");
                if(current.left != null)
                    q.add(current.left);
                if(current.right != null)
                    q.add(current.right);
            }
        }
        return count;
    }

    public static int totalNodes(Node3 root){
        int total = 1;
        if(root == null) return 0;
        Queue<Node3> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node3 current = q.remove();
            if(current == null){
                //System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                //System.out.print(current.data+" ");
                if(current.left != null){
                    q.add(current.left);
                    total++;
                }
                if(current.right != null) {
                    q.add(current.right);
                    total++;
                }
            }
        }
        return total;
    }

    public static int levelOfAGivenNode(Node3 root, int data){
        if(root == null) return 0;
        int total = 1;
        Queue<Node3> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        if(root.data == data) return 1;

        while(!q.isEmpty()){
            Node3 current = q.remove();
            if(current == null){
                total++;
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                if(current.left != null){
                    q.add(current.left);
                    if(current.left.data == data){
                        total++;
                        break;
                    }
                }
                if(current.right != null){
                    q.add(current.right);
                    if(current.right.data == data){
                        total++;
                        break;
                    }
                }
            }

        }
        if(total > heightOfTree(root) || total < 0) {
            System.out.println("Invalid input!");
            return 0;
        }
        else
            return total;
    }

    public static int sumOfAllNodes(Node3 root){
        if(root == null) return 0;

        int leftSum = sumOfAllNodes(root.left);
        int rightSum = sumOfAllNodes(root.right);

        return leftSum + rightSum + root.data; // only by replacing root.data with 1, this exact same method gives total number of nodes
    }
    public static int totalOfAllNodesUsingRecursion(Node3 root){
        if(root == null) return 0;

        int leftSum = totalOfAllNodesUsingRecursion(root.left);
        int rightSum = totalOfAllNodesUsingRecursion(root.right);

        return leftSum + rightSum + 1;
    }

    public static int heightUsingRecursion(Node3 root){
        if(root == null) return 0;

        int leftHeight = heightUsingRecursion(root.left);
        int rightHeight = heightUsingRecursion(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    public static boolean isSameLevel(Node3 root, int data1, int data2){
        if(root == null) return false;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.data);
        list.add(null);
        Queue<Node3> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node3 current = q.remove();
            if(current == null){
                list.add(null);
                if(q.isEmpty()) break;
                else q.add(null);
            }
            else{
                if(current.left != null){
                    q.add(current.left);
                    list.add(current.left.data);
                }
                if(current.right != null){
                    q.add(current.right);
                    list.add(current.right.data);
                }
            }
        }
        int condition = -1;
        for(int i = 0; i < list.size(); i++){
            while(list.get(i) != null){
                if(list.get(i) == data1){
                    condition++;
                }
                if(list.get(i) == data2){
                    condition++;
                }
                if(condition == 1) {
                    return true;
                }
                i++;
            }
            condition = -1;
        }
        return false;
    }

    public static int maxValue(Node3 root){
        if(root == null) return Integer.MIN_VALUE;

        int value = root.data;
        int leftMax = maxValue(root.left);
        int rightMax = maxValue(root.right);

        return Math.max(value, Math.max(leftMax, rightMax));
    }

    public static int minValue(Node3 root){
        if(root == null) return Integer.MAX_VALUE;

        int value = root.data;
        int leftMin = minValue(root.left);
        int rightMin = minValue(root.right);

        return Math.min(value, Math.min(leftMin, rightMin));
    }
    static boolean isBST(Node3 root)
    {
        if (root == null) {
            return true;
        }
        if (root.left != null && maxValue(root.left) > root.data) {
            return false;
        }
        if (root.right != null && minValue(root.right) < root.data) {
            return false;
        }
        if (isBST(root.left) != true || isBST(root.right) != true) {
            return false;
        }
        return true;
    }

    public static void breadthFirstInsertion(Node3 root, int key){
        Node3 current = new Node3(key);
        if(root == null){
            root = current;
        }
        else {
            Queue<Node3> q = new LinkedList<>();
            q.add(root);

            while(!q.isEmpty()){
                current = q.remove();
                if(current.left == null){
                    current.left = new Node3(key);
                    break;
                }
                else
                    q.add(current.left);
                if(current.right == null){
                    current.right = new Node3(key);
                    break;
                }
                else
                    q.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        BTPractice tree = new BTPractice();
        int[] Nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1}; // building tree from
        // pre order traversal

        //int[] Nodes = {50, 40, 37, 32, -1, -1, 39, -1, -1, 45, 43, -1, -1, 47, 46, -1, -1, -1, 60, -1, 70, 65, 62, -1, -1, 69, -1, -1, -1};

        //int[] Nodes = {2, -1, 3, -1, -1};

        Node3 root = tree.buildTree(Nodes);
        //System.out.println(root.data);


        // depth first traversal is pre post and in order
        //tree.preOrder(root);                          // prints the tree in pre-order traversal
        //tree.postOrder(root);                         // prints the tree in post-order traversal
        //tree.inOrder(root);                           // prints the tree in in-order traversal


        // breadth first traversal is level order traversal
        tree.breadthFirst(root);


        // Height of tree
        //int count = tree.heightOfTree(root);
        //System.out.println(count);

        // height using recursion
        //System.out.println(heightUsingRecursion(root));


        // Total number of nodes
        //int total = tree.totalNodes(root);
        //System.out.println(total);


        // level of some specific node
        //int level = tree.levelOfAGivenNode(root, 19);
        //System.out.println(level);


        // sum of all nodes
//            int sum = tree.sumOfAllNodes(root);
//            System.out.println(sum);


        // two nodes at same level or not
        //System.out.println(isSameLevel(root, 37, 40));

        // checking for BST
        //System.out.println(isBST(root));

        // min max values in a tree
        //System.out.println(maxValue(root));
        //System.out.println(minValue(root));

        // insertion using breadth first
        //breadthFirstInsertion(root, 6);

        System.out.println();
        System.out.println(sumOfAllNodes(root));

   }
}