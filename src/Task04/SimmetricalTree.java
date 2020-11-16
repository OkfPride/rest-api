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
public class SimmetricalTree<T extends Comparable> {

    public static void main(String[] args) {
        SimmetricalTree<Integer> simmetricalTree = new SimmetricalTree<Integer>();
        simmetricalTree.add(10);
//        simmetricalTree.add(5);
//        simmetricalTree.add(4);
//        simmetricalTree.add(7);
//        simmetricalTree.add(8);
//        simmetricalTree.add(3);
//        simmetricalTree.add(6);
//        simmetricalTree.add(7);
//        simmetricalTree.add(9);
//        simmetricalTree.add(12);
//        simmetricalTree.add(33);
//        simmetricalTree.add(34);
//        simmetricalTree.showTreeBFS();
System.out.println("recursive = "+simmetricalTree.maxDepth(simmetricalTree.head));
        simmetricalTree.showTreeDFS();
//        System.out.println(simmetricalTree.isSimmetric(10));
    }
    Node<T> head;
    LinkedList<Node> list = new LinkedList<>();
    Node currentNode;

    private void addTo(T value, Node<T> parent) {
        if (parent.value.compareTo(value) > 0) {
            if (parent.left == null) {
                parent.left = new Node<>(value);
                parent.left.parent = parent;
                count++;
            } else {
                addTo(value, parent.left);
            }
        } else if (parent.value.compareTo(value) <= 0) {
            if (parent.right == null) {
                parent.right = new Node<>(value);
                parent.right.parent = parent;
                count++;
            } else {
                addTo(value, parent.right);
            }
        }
    }

    int count = 0;

    private void addSimetric(T value, Node<T> parent) {
//        int count = 1;
        if (count % 2 != 0) {
            if (parent.left == null) {
                parent.left = new Node<>(value);
                parent.left.parent = parent;
                count++;
            } else {
                addSimetric(value, parent.left);
            }
        } else {
            if (parent.right == null) {
                parent.right = new Node<>(value);
                parent.right.parent = parent;
                count++;
            } else {
                addSimetric(value, parent.right);
            }

        }
    }

    int maxDepth(Node curNode) {
        if (curNode==null) {
            return 0;
        }
        if (curNode.left == null && curNode.right == null) {
            return 1;
        } else {
            return 1+ Math.max(maxDepth(curNode.left), maxDepth(curNode.right));
        }
    }

    private void showTreeDFS() {
        int maxDepth = 0;
        int curDepth = 0;
        list.push(head);
        head.isVisited = true;
        curDepth++;
        if (maxDepth < curDepth) {
            maxDepth = curDepth;
        }
        while (!list.isEmpty()) {
            Node showLAST = list.peek();
            if (showLAST.isVisited == false) {
                System.out.println(showLAST.value);
            }

            if ((showLAST.left == null && showLAST.right == null)) {
                showLAST.isVisited = true;
                list.pop();
                curDepth--;
                continue;
            }

            if (showLAST.left == null && showLAST.right.isVisited == true) {
                showLAST.isVisited = true;
                list.pop();
                curDepth--;
                continue;
            }

            if (showLAST.left != null && showLAST.left.isVisited != true) {

                list.push(showLAST.left);
                curDepth++;
                if (maxDepth < curDepth) {
                    maxDepth = curDepth;
                }
                continue;
            }

            if (showLAST.right != null && showLAST.right.isVisited != true) {
                list.push(showLAST.right);
                curDepth++;
                if (maxDepth < curDepth) {
                    maxDepth = curDepth;
                }
                continue;
            } else if (showLAST.right == null && showLAST.left.isVisited == true) {
                showLAST.isVisited = true;
                list.pop();
                curDepth--;
            }
            if ((showLAST.left != null && showLAST.right != null) && (showLAST.left.isVisited == true && showLAST.right.isVisited == true)) {
                showLAST.isVisited = true;
                list.pop();
                curDepth--;
            }
        }
        System.out.println("max depth = " + maxDepth);
    }

    int showTreeDFSIntern(Node CurNode) {
        if (CurNode.isVisited) {

        }
        return -1;
    }

    class Node<T extends Comparable> {

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }

        Node<T> parent;
        Node<T> left;
        Node<T> right;
        T value;
        boolean isVisited;

        public Node(T value) {
            this.value = value;
        }
    }

    void showTreeBFS() {
        list.add(head);
        while (!list.isEmpty()) {
            Node pop = list.pop();
            System.out.println(pop.value);
            if (pop.left != null) {
                list.add(pop.left);
            }
            if (pop.right != null) {
                list.add(pop.right);
            }
        }
    }

    boolean isSimmetric(int i) {
        return isSimmetricInternal(head, head);

    }

    boolean isSimmetricInternal(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.value == right.value
                && isSimmetricInternal(left.left, right.right)
                && isSimmetricInternal(left.right, right.left);

    }

    void add(T value) {
        if (head == null) {
            head = new Node<>(value);
            count++;
        } else {
            addTo(value, head);
//            addSimetric(value, head);
        }
    }
}
