package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public Node root;

    public static class Node {

        public int value;

        public Node left;

        public Node rigth;

        public Node(int value) {
            this.value = value;

        }
        public boolean isLeaf() {
            return (this.left == null) && (this.rigth == null);
        }

    }

    public void insert(int value) {
        if (root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                Node currentNode = queue.remove();
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.rigth);
                }
                if (currentNode.rigth == null) {
                    currentNode.rigth = newNode;
                    break;
                } else {
                    queue.add(currentNode.rigth);
                }
            }
        }

    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(final Node node) {
        // Raiz Esquerda Direita
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.rigth);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        // Esquerda Raiz Direita
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.rigth);
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(final Node node) {
        // Esquerda Direita Raiz
        if (node == null) return;
        posOrder(node.left);
        posOrder(node.rigth);
        System.out.println(node.value);
    }


    public void BFS() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.rigth != null) queue.add(node.rigth);

            System.out.println(node.value);

        }
    }




































    public static void main(String[] args) {
            Tree tree = new Tree();
            tree.insert(37);
            tree.insert(11);
            tree.insert(66);
            tree.insert(8);
            tree.insert(17);
            tree.insert(42);
            tree.insert(72);

        System.out.println("############################");
        tree.BFS();
        System.out.println("############################");







//        Tree tree = new Tree();
//        tree.insert(1);
//        tree.insert(2);
//        tree.insert(3);
//
//        System.out.println(tree.root.value);
//        System.out.println(tree.root.left.value);
//        System.out.println(tree.root.rigth.value);
//
//        System.out.println(tree.root.isLeaf());
//        System.out.println(tree.root.rigth.isLeaf());

    }






}
