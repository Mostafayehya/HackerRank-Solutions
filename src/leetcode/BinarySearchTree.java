package leetcode;

import java.io.*;
import java.util.*;

class Node {
    String value;
    Node left;
    Node right;

    boolean visitedLeft;
    boolean visitedRight;

    public boolean isVisitedLeft() {
        return visitedLeft;
    }

    public void setVisitedLeft(boolean visitedLeft) {
        this.visitedLeft = visitedLeft;
    }

    public boolean isVisitedRight() {
        return visitedRight;
    }

    public void setVisitedRight(boolean visitedRight) {
        this.visitedRight = visitedRight;
    }

    public Node(String value) {
        this.value = value;
    }

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public String getValue() {
        return value;
    }

    public Node getRight() {
        return right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public boolean hasLeftChild() {
        return left != null;
    }

    public boolean hasRightChild() {
        return right != null;
    }

    @Override
    public String toString() {
        return "Node(" + value + ")";
    }
}

class Tree {
    Node root;

    public Tree() {
    }

    public Tree(String value) {
        this.root = new Node(value);
    }

    public Node getRoot() {
        return root;
    }
}

public class BinarySearchTree {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Tree tree = new Tree("Apple");
        tree.getRoot().setLeft(new Node("Banana"));
        tree.getRoot().setRight(new Node("Cheery"));

        tree.getRoot().getLeft().setLeft(new Node("dates"));

        //preOrderWithStack(tree);
        Node node = tree.getRoot();

        // Pre-Order Traversal
        List<Node> visitOrder = new ArrayList<>();
        preOrderTraversalWithRecursion(node, visitOrder);
        System.out.println("Pre-Order traversal: " + visitOrder);

        // In-Order Traversal
        visitOrder = new ArrayList<>();
        inOrderTraversalWithRecursion(node, visitOrder);
        System.out.println("In-Order traversal: " + visitOrder);

        // Post-Order Traversal
        visitOrder = new ArrayList<>();
        postOrderTraversalWithRecursion(node, visitOrder);
        System.out.println("Post-Order traversal: " + visitOrder);


    }

    public static void preOrderTraversalWithRecursion(Node node, List<Node> visited) {

        visited.add(node);
        if (node.hasLeftChild() && !node.visitedLeft)
            preOrderTraversalWithRecursion(node.left, visited);

        if (node.hasRightChild() && !node.visitedRight)
            preOrderTraversalWithRecursion(node.right, visited);


    }

    public static void inOrderTraversalWithRecursion(Node node, List<Node> visited) {

        if (node.hasLeftChild() && !node.visitedLeft)
            inOrderTraversalWithRecursion(node.left, visited);

        visited.add(node);


        if (node.hasRightChild() && !node.visitedRight)
            inOrderTraversalWithRecursion(node.right, visited);

    }

    public static void postOrderTraversalWithRecursion(Node node, List<Node> visited) {

        if (node.hasLeftChild() && !node.visitedLeft)
            postOrderTraversalWithRecursion(node.left, visited);

        if (node.hasRightChild() && !node.visitedRight)
            postOrderTraversalWithRecursion(node.right, visited);

        visited.add(node);


    }


    public static void preOrderWithStack(Tree tree) {
        List<Node> visitOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node node = tree.getRoot();
        stack.push(node);

        node = stack.peek();

        visitOrder.add(node);
        int count = 0;
        int loopLimit = 9;

        while (node != null && count < loopLimit) {
            count++;
            System.out.format("loop count: %d\ncurrent node: %s\nstack:%s\nvisit order: %s\n", count, node, stack, visitOrder);
            System.out.println();
            System.out.println();

            if (node.hasLeftChild() && !node.visitedLeft) { // Beaware that this will skip duplicate nodes in the BST
                node.visitedLeft = true;
                node = node.getLeft();
                stack.push(node);
                node = stack.peek();

                visitOrder.add(node);
            } else if (node.hasRightChild() && !node.visitedRight) {
                node.visitedRight = true;
                node = node.getRight();
                stack.push(node);
                node = stack.peek();
                visitOrder.add(node);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    node = stack.peek();
                } else {
                    node = null;
                }
            }
        }

    }
}

