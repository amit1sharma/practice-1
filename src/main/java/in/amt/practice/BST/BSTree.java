package in.amt.practice.BST;

/**
 * Created by amit.sharma5 on 29/08/17.
 */
public class BSTree {
    Node root;

    BSTree(){
        root = null;
    }

    public void insertData(int data){
        this.root = this.insertRecord(this.root, data);
    }

    private Node insertRecord(Node node, int data){
        if(node==null){
            return new Node(data);
        } else if(data > node.value){
            node.right = this.insertRecord(node.right,data);
        } else if(data < node.value){
            node.left = this.insertRecord(node.left,data);
        }
        return node;
    }

    private void findKthLargestValue(Node root, int k, Counter counter){
        if(root == null){
            return;
        }
        this.findKthLargestValue(root.right, k, counter);
        counter.c ++;
        if(counter.c == k){
            System.out.println(root.value);
        }
        this.findKthLargestValue(root.left, k , counter);
    }

    private void findKthSmallestValue(Node root, int k, Counter counter){
        if(root == null){
            return;
        }
        this.findKthLargestValue(root.left, k, counter);
        counter.c ++;
        if(counter.c == k){
            System.out.println(root.value);
        }
        this.findKthLargestValue(root.right, k , counter);
    }

    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insertData(9);
        tree.insertData(3);
        tree.insertData(4);
        tree.insertData(7);
        tree.insertData(11);
        tree.insertData(18);
        tree.insertData(10);
        /**
         * Class variable is used as counter or else each recursion will create its own member variable and doesn't use a main counter.
         */
        tree.findKthLargestValue(tree.root, 9, new Counter());
        tree.findKthSmallestValue(tree.root, 9, new Counter());
    }
}

/**
 * this class is used because class object is saved in heap and each stack will have access to the same class
 */
class Counter{
    int c=0;
}
