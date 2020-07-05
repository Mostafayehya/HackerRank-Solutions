package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
    static class Node {
        String value;
        Node leftChild;
        Node rightChild;

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

        public Node(String value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public String getValue() {
            return value;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public boolean hasLeftChild() {
            return leftChild != null;
        }

        public boolean hasRightChild() {
            return rightChild != null;
        }

        @Override
        public String toString() {
            return "Node(" + value + ")";
        }
    }

    static class Tree {
        Node root;

        public Tree() {
        }

        public Tree(String value) {
            this.root = new Node(value);
        }

        public Node getRoot() {
            return root;
        }

        @Override
        public String toString() {
            LinkedList<Node> queue = new LinkedList<>();

            StringBuilder sb = new StringBuilder();
            queue.add(root);
            sb.append(root);

            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                sb.append("\n");
                if (node.hasLeftChild()) {
                    queue.add(node.leftChild);
                    sb.append(node.leftChild + "|");
                } else {
                    sb.append("<empty>|");
                }
                if (node.hasRightChild()) {
                    queue.add(node.rightChild);
                    sb.append(node.rightChild + "|");
                } else {
                    sb.append("<empty>|");
                }


            }

            return sb.toString();
        }


        public static void main(String[] args) {

            Tree tree = new Tree("Apple");
            tree.getRoot().setLeftChild(new Node("Banana"));
            tree.getRoot().setRightChild(new Node("Cheery"));

            tree.getRoot().getLeftChild().setLeftChild(new Node("dates"));


               BFS(tree);

        }

        private static void BFS(Tree tree) {
            LinkedList<Node> queue = new LinkedList<>();

            List<Node> visitOrder = new ArrayList<>();

            queue.add(tree.root);

            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                visitOrder.add(node);

                if (node.hasLeftChild())
                    queue.add(node.leftChild);
                if (node.hasRightChild())
                    queue.add(node.rightChild);
                System.out.println("visit order: " + visitOrder);
            }
        }
    }
}
