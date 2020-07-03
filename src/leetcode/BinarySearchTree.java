package leetcode;

import java.io.*;
import java.util.*;

public class BinarySearchTree {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Tree tree = new Tree("Apple");
        tree.getRoot().setLeft(new Node("Banana"));
        tree.getRoot().setRight(new Node("Cheery"));

        tree.getRoot().getLeft().setLeft(new Node("dates"));

        preOrderWithStack(tree);


    }

    public static void preOrderWithStack(Tree tree) {
        List<Node> visitOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        Node node = tree.getRoot();
        stack.push(node);

        node = stack.peek();

        visitOrder.add(node);
        int count = 0;
        int loopLimit = 7;

        while (node != null && count < loopLimit) {
            count++;
            System.out.format("loop count: %d\ncurrent node: {%s}\nstack:{%s}\n", count, node, stack);
            System.out.println();
            System.out.println();

            if (node.hasLeftChild()) {
                node = node.getLeft();
                stack.push(node);
                node = stack.peek();
                visitOrder.add(node);
            } else if (node.hasRightChild()) {
                node = node.getRight();
                stack.push(node);
                node = stack.peek();
                visitOrder.add(node);
            } else {
                stack.pop();
                if(!stack.isEmpty()){
                    node = stack.peek();
                }else{
                    node = null;
                }
            }
        }

    }
}

class Node {
    String value;
    Node left;
    Node right;

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