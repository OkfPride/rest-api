/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task04;

import java.util.LinkedList;

/**
 *
 * @author summe
 */
public class ReverseList<T> {

    Node<T> head;
    Node<T> currentNode;

    public static void main(String[] args) {
        ReverseList<Integer> reverseList = new ReverseList<Integer>();
        reverseList.add(3);
        reverseList.add(2);
        reverseList.add(1);
        reverseList.showList();
        
        Node<Integer> reverse = reverseList.reverse(reverseList.head);
        System.out.println(reverse.next.next.next);
//        reverseList.showList();
    }

    static <T> LinkedList reverseList(LinkedList<T> inputLL) {
        LinkedList<T> linkedList = new LinkedList<>();
        while (!inputLL.isEmpty()) {
            linkedList.push(inputLL.pop());
        }
        return linkedList;
    }

    Node<T> reverse(Node<Integer> headd) {
        Node CurNode = headd;
        Node previous = null;
        Node nextNode;
        while (CurNode.next != null) {
            nextNode= CurNode.next;
            CurNode.next = previous;
            previous=CurNode;
            CurNode=nextNode;
        }CurNode.next= previous;
        return CurNode;
    }

    Node reverseInternal(Node parent, Node head) {
        if (head.next == null) {
            return head;
        } else {
            head = reverseInternal(head, head.next);
            head.next = parent;
            return head.next;
        }
    }

    static class Node<T> {

        Node next;
        T value;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }

    }

    void add(T value) {
        if (head == null) {
            head = new Node(value);
            currentNode = head;
        } else {
            Node node = new Node(value);
            node.next = head;
            head = node;
//            addInternal(value, head);

        }
    }

    private void addInternal(T value, Node<T> boss) {
        boss.next = new Node(value);
    }

    void showList() {
        Node face = head;
        while (face != null) {
            System.out.println(face.value);
            face = face.next;
        }
    }
}
