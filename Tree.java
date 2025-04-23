import java.util.Scanner;

public class Tree {
    public static int findHieght(Node root) {
        if(root == null) return 0;
        int left = findHieght(root.left);
        int right = findHieght(root.right);
        return Math.max(left,right) + 1;
    }

    public static int findNodes(Node root) {
        if(root == null) return 0;
        return 1 + findNodes(root.left) + findNodes(root.right);
    }

    public static boolean searchNode(Node root,int data) {
        if(root == null) return false;
        if(root.data == data) return true;
        boolean left = searchNode(root.left,data);
        boolean right = searchNode(root.right,data);
        return left || right;
    }

    public static int countLeaf(Node root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = countLeaf(root.left);
        int right = countLeaf(root.right);
        return left + right;
    }

    public static int sumOfNodes(Node root) {
        if(root == null) return 0;
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return root.data + left + right;
    }

    public static void printLevel(Node root,int level,int index) {
        if(root == null) return;
        
        if(level == index) System.out.print(root.data + " ");
        printLevel(root.left,level,index + 1);
        printLevel(root.right,level,index + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        System.out.println("Hieght: " + findHieght(root));
        System.out.println("Number of Node's: " + findNodes(root));
        System.out.println("Node exist or not ? : " + searchNode(root,20));
        System.out.println("Number of leaf node's: " + countLeaf(root));
        System.out.println("Sum is: " + sumOfNodes(root));
        printLevel(root,2,0);

        return;
    }
}


class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}