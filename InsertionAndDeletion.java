import java.util.Queue;
import java.util.LinkedList;

public class InsertionAndDeletion {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static void insert(Node root,int key) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node front = q.remove();
            if(front == null) {
                if(!q.isEmpty()) {
                    q.add(null);
                }
            }else {
                if(front.left == null) {
                    front.left = new Node(key);
                    break;
                }
                if(front.right == null) {
                    front.right = new Node(key);
                    break;
                }


                if(front.left != null) {
                    q.add(front.left);
                }
                if(front.right != null) {
                    q.add(front.right);
                }
            }

        }
    }

    public static Node delete(Node root,int key) {

        if(root == null) return null;
        
        if(root.data == key) {
            if(root.left == null && root.right == null) {
                return null;
            }

            if(root.left == null) {
                return root.right;
            }

            if(root.right == null) {
                return root.left;
            }

            Node leafNode = findLeafNode(root);
            int temp = root.data;
            root.data = leafNode.data;
            leafNode.data = temp;


        }

        root.left = delete(root.left,key);
        root.right = delete(root.right,key);
        return root;
    }
    public static Node findLeafNode(Node root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) {
            return root;
        }
        Node left = findLeafNode(root.left);
        Node right = findLeafNode(root.right);
        if(left == null && right == null) {
            return null;
        }
        return left;
    }
    public static void inOrder(Node root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);

        root.left.left = new Node(40);

        root.right.left = new Node(50);
        root.right.right = new Node(60);

        System.out.println("Before Insertion: ");
        inOrder(root);
        insert(root,100);
        System.out.println("\nAfter insertion: ");
        inOrder(root);

        delete(root,10);
        System.out.println("\nAfter Deletion: ");
        inOrder(root);
        return;
    }
}