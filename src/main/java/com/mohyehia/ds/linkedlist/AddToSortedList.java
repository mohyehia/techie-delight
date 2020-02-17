package com.mohyehia.ds.linkedlist;

/*
Insert given node into the correct sorted position in the given sorted linked list
https://www.techiedelight.com/sorted-insert-in-linked-list/
time complexity => O(N) where N is the size of list
space complexity => O(N) as we create two nodes
 */
public class AddToSortedList {
    static Node addToSortedList(Node head, Node node){
        if(head == null) return node;
        if(node.val <= head.val){
            node.next = head;
            return node;
        }
        Node prev = head, current = head.next;
        while(current != null){
            if(node.val <= current.val){
                node.next = prev.next;
                prev.next = node;
                return head;
            }
            prev = current;
            current = current.next;
        }
        /*
            the node value is greater than all of the elements so,
            append the node to the last element
         */
        node.next = prev.next;
        prev.next = node;
        return head;
    }

    static Node betterAdd(Node head, Node node){
        if(head == null)
            return node;
        if(node.val <= head.val){
            node.next = head;
            return node;
        }
        Node current = head;
        while(current.next != null && current.next.val < node.val)
            current = current.next;
        // add the node at this position
        node.next = current.next;
        current.next = node;
        return head;
    }

    static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // input keys
        int[] keys = {1, 2, 5, 6, 8, 10};
        // points to the head node of the linked list
        Node head = null;
        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
        print(head);
        head = betterAdd(head, new Node(7, null));
        System.out.println("after adding to sorted list");
        print(head);
    }
}

class Node{
    int val;
    Node next;

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}