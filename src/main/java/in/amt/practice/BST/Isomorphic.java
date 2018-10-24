package in.amt.practice.BST;

/**
 * Created by amit.sharma5 on 30/08/17.
 */
public class Isomorphic {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        BSTree tree1 = new BSTree();
        /*
        tree.insertData(9);
        tree.insertData(3);
        tree.insertData(4);
        tree.insertData(7);
        tree.insertData(11);
        tree.insertData(18);
        tree.insertData(10);


        tree1.insertData(9);
        tree1.insertData(11);
        tree1.insertData(4);
        tree1.insertData(7);
        tree1.insertData(3);
        tree1.insertData(18);
        tree1.insertData(10);
*/


        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(8);

        tree1.root = new Node(1);
        tree1.root.left = new Node(3);
        tree1.root.right = new Node(2);
        tree1.root.right.left = new Node(4);
        tree1.root.right.right = new Node(5);
        tree1.root.left.right = new Node(6);
        tree1.root.right.right.left = new Node(8);
        tree1.root.right.right.right = new Node(7);


        System.out.println(isIsomorphic(tree1.root, tree.root));
    }

    private static boolean isIsomorphic(Node n1, Node n2){
        if(n1==null && n2==null)
            return true;

        if (n1==null || n2==null)
            return false;

        if(n1.value != n2.value)
            return false;

        return (isIsomorphic(n1.left,n2.left) && isIsomorphic(n1.right,n2.right)) ||
                (isIsomorphic(n1.left,n2.right) && isIsomorphic(n1.right,n2.left)) ;
    }
}
