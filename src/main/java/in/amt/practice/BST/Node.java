package in.amt.practice.BST;

/**
 * Created by amit.sharma5 on 29/08/17.
 */
public class Node {
    int value;
    Node left,right;

    public Node(int value){
        this.value = value;
        this.left = this.right = null;
    }
    public Node(){
        this.left = this.right = null;
    }

}
