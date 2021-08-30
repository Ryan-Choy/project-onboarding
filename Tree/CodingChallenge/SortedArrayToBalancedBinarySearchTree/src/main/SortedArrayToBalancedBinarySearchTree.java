package main;

import java.util.Arrays;

//store int values and keep references to each child
class Node {
    //input
    int data;
    //recursive variables
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

}

public class SortedArrayToBalancedBinarySearchTree {

    // starting node
    static Node root;

    public Node sortedArrayToBinarySearchTree(int sortedArray[], int start, int end) {
        // starting case
        if (start > end) {
            return null;
        }
        // set the middle element as the root
        int mid = (start + end) / 2;
        Node node = new Node(sortedArray[mid]);

        // recursive construction of left subtree and assign it as the left child of the
        // root
        node.left = sortedArrayToBinarySearchTree(sortedArray, start, mid - 1);

        // recursive construction of right subtree and assign it as the right child of
        // the root
        node.right = sortedArrayToBinarySearchTree(sortedArray, mid + 1, end);

        return node;
    }

    public void previousOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        previousOrder(node.left);
        previousOrder(node.right);
    }

    public static void main(String[] args) {
        SortedArrayToBalancedBinarySearchTree binaryTree = new SortedArrayToBalancedBinarySearchTree();
        // sample input
        int[] sortedArray = { 19,5,4,88,66,22};
        int n = sortedArray.length;
        Arrays.sort(sortedArray);

        root = binaryTree.sortedArrayToBinarySearchTree(sortedArray, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST by going down the left branch first.");
        binaryTree.previousOrder(root);
    }

}
