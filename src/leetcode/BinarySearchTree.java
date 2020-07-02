package leetcode;

import java.io.*;
import java.util.*;

public class BinarySearchTree {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);

        node0.setLeft(node1);
        node0.setRight(node2);

        System.out.format("node0 value =%d\n",node0.value);
        System.out.format("node0 left value =%d\n",node0.left.value);
        System.out.format("node0 right value =%d\n",node0.right.value);
        System.out.format("node0 has left? %b\n",node0.hasLeftChild());
        System.out.format("node0 has right? %b\n",node0.hasRightChild());

    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
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

}


class Tree{
    Node root;

    public  Tree(){ }

    public Tree(int value){
        this.root = new Node(value);
    }

    public Node getRoot(){
        return root;
    }
}