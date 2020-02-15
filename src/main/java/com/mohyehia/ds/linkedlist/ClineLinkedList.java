package com.mohyehia.ds.linkedlist;

public class ClineLinkedList {
    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
    }

    @SuppressWarnings("unused")
    static Node clone(Node head) {
        if (head == null)
            return null;
        Node current = head.next;
        Node clonedNode = new Node(head.val, null);
        Node temp = clonedNode;
        while (current != null) {
            temp.next = new Node(current.val, null);
            temp = temp.next;
            current = current.next;
        }
        return clonedNode;
    }

    // recursive function to clone a linkedList
    static Node recursiveClone(Node head){
        // base case
        if(head == null)
            return null;
        Node node = new Node(head.val, null);
        node.next = recursiveClone(head.next);
        return node;
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = {1, 2, 3, 4, 5, 6, 7, 8};
        // points to the head node of the linked list
        Node head = null;
        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        // copy linked list
        Node copy = recursiveClone(head);
        // print duplicate linked list
        print(copy);
    }
}
