package org.example.algorithm.list;

import lombok.var;

public class ReverseList {


    public static void main(String[] args) {


        var nodeA = new Node("A");
        var nodeB = new Node("B");
        nodeA.next = nodeB;
//        nodeB.next = new Node("C");

        print(nodeA);
        Node reverse = reverse(nodeA);
        print(reverse);
    }

    public static Node reverse(Node node) {
        if (node == null || node.next == null) return node;
        Node newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }



    public static void print(Node node) {

        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }

        System.out.println();
    }




}

class Node {

    final String data;

    Node next;

    public Node(String data) {
        this.data = data;
    }
}
