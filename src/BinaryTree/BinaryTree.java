package DataStructures.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Includes all the core functionalities of Binary Tree.
 * <p>Also includes manual creation of tree as it is a Binary Tree and not Binary Search Tree.</p>
 */
public class BinaryTree {

    /**
     * Defines the structure of every Nodes in Binary Tree.
     */
    public class Node{
        /**
         * The value to be stored in Node.
         */
        int data;
        /**
         * The Pointer to left child of a Node.
         */
        Node left;
        /**
         * The Poinnter to right child of a Node.
         */
        Node right;

        /**
         * Initializes a new Node.
         * @param data The value to be stored in Node.
         */
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private static int idx;
    /**
     * Builds a Binary Tree with given PreOrder array.
     * @param nodes The PreOrder arrangement of values.
     * @return The root Node of built Tree.
     */
    public Node buildBinaryTreeWithPreOrder(int nodes[]){
        idx = -1;
        return buildBTreePreOrder(nodes);
    }

    private Node buildBTreePreOrder(int nodes[]){
        idx++;
        if (nodes[idx] == -1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildBTreePreOrder(nodes);
        newNode.right = buildBTreePreOrder(nodes);
        return newNode;
    }

    /**
     * Prints Node while traversing with PreOrder traversal.
     * @param root The root of the tree.
     */
    public void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * Prints Node while traversing with InOrder traversal.
     * @param root The root of the tree.
     */
    public void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * Prints Node while traversing with PostOrder traversal.
     * @param root The root of the tree.
     */
    public void postOrder(Node root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    /**
     * Prints Node while traversing with LevelOrder traversal.
     * @param root The root of the tree.
     */
    public void levelOrder(Node root){
        if (root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if (currNode == null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    /**
     * Calculates the height of a given Node.
     * @param node The height of which to be calculated.
     * @return The length of longest path available from givem Node to leaf Node.
     */
    public int height(Node node){
        if (node == null){
            return 0;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }

    /**
     * Counts the number of Nodes present in the binary tree.
     * @param node The root of a tree.
     * @return The number of Nodes present in the given tree.
     */
    public int count(Node node){
        if (node == null){
            return 0;
        }
        return count(node.left) + count(node.right) + 1;
    }

    /**
     * Calculates the sum of data present in the Nodes.
     * @param node The root of a tree of subTree.
     * @return The sum of values in every Node.
     */
    public int sum(Node node){
        if (node == null){
            return 0;
        }
        return sum(node.left) + sum(node.right) + node.data;
    }

    /**
     * The class to be utilized to calculate the diameter of a tree.
     * <p>It stores the diameter and height required in calculation.</p>
     */
    private class Info {
        int diameter;
        int height;
        public Info(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    /**
     * Calculates the diameter of a tree.
     * @param node The root of a tree or subTree.
     * @return diameter of the given tree.
     */
    public int diameter(Node node){
        return dia(node).diameter;
    }

    /**
     * Utilized by method diameter used to be recursively called to calculate the diameter.
     * @param node The root of tree or a subTree.
     * @return The object of Info class which will be utilized to keep track of height and diameter.
     */
    private Info dia(Node node){
        if (node == null){
            return new Info(0, 0);
        }
        Info left = dia(node.left);
        Info right = dia(node.right);
        int diameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height + 1);
        int height = Math.max(left.height, right.height) + 1;
        return new Info(diameter, height);
    }

//    public static void main(String[] args) {
//        BinaryTree b = new BinaryTree();
//        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
//        Node t = b.buildBinaryTreeWithPreOrder(nodes);
//        System.out.println(t.data);
//        b.preOrder(t);
//        b.inOrder(t);
//        b.postOrder(t);
//        b.levelOrder(t);
//        System.out.println(b.height(t.left.left));
//        System.out.println(b.count(t));
//        System.out.println(b.sum(t));
//        System.out.println(b.diameter(t));
//    }
}
