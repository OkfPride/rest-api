/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import java.util.Optional;
import java.util.TreeMap;

/**
 *
 * @author summe
 */
class test {

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(10);
        tree.add(7);
        tree.add(3);
        tree.add(8);
        tree.add(9);
        tree.add(22);
        tree.add(20);
        tree.add(23);
//        System.out.println(tree.contains(1002));
        tree.showTreeStrait();
        System.out.println("==============================");
        tree.remove(23);
        tree.showTreeStrait();

//        new TreeMap<Object, Object>ap();
    }
}

public class Tree<T extends Comparable> {
private Node nodeForDelete;
    private Node root;

    void add(T value) {
        if (root == null) {
            root = new Node<T>(value);
        } else {
            addTo(root, value);
        }

    }

    void remove(T value) {
        if (contains(value)) {
            remove(value, root);
        } else {
            System.out.println("not contains");
        }
    }

    private void remove(T value, Node currentNODE) {
        currentNODE = removeSUPPORT(value);
        if (currentNODE != null) {
            //0 var
            if (currentNODE.left==null&&currentNODE.rightNode==null) {
//                System.out.println(currentNODE.parent.left.value);
                if (currentNODE.parent.left!=null&&value.compareTo(currentNODE.parent.left.value)==0) {
                currentNODE.parent.left=null;
                }else{
                currentNODE.parent.rightNode=null;
                }
            }
            //1st varian
            if (currentNODE.left != null && currentNODE.rightNode == null) {
                currentNODE.parent.left = currentNODE.left;
                currentNODE.left = null;
            }else if (currentNODE.rightNode != null && currentNODE.left == null) {
                currentNODE.parent.rightNode = currentNODE.rightNode;
                currentNODE.rightNode = null;
            }
            //2th variant
            else if(currentNODE.left!=null&&currentNODE.rightNode.rightNode!=null&&currentNODE.rightNode.left==null){
                currentNODE.parent.left=currentNODE.rightNode;
                currentNODE.rightNode.left=currentNODE.left;
                currentNODE.rightNode.parent=currentNODE.parent;
                currentNODE=null;
            }
            
            
        }else{
            System.out.println("curnode = null");
        }
    }

    boolean contains(T value) {

        return contains(value, root) != null;
    }

    void showTreeStrait() {
        showTreeStrait(root);
    }

    private Node removeSUPPORT(T value) {
        removeSUPPORT(root, value);
        return nodeForDelete;
    }

    private void removeSUPPORT(Node<T> currentNODE, T value) {
        if (currentNODE.value.compareTo(value) == 0) {
//            System.out.println("find node " + currentNODE.value+"left = "+new Optional<T>(currentNODE.value));
            nodeForDelete=currentNODE;
            
        }
        if (currentNODE.left != null) {
            removeSUPPORT(currentNODE.left, value);
        }
        if (currentNODE.rightNode != null) {
            removeSUPPORT(currentNODE.rightNode, value);
        }
        
    }

    private void showTreeStrait(Node<T> parent) {

        if (parent.left != null) {
            showTreeStrait(parent.left);
        }
        if (parent.parent!=null) {
        System.out.println(parent.value + " parent node(value) = " + parent.parent.value);
        }else{
        System.out.println(parent.value + " parent node(value) = " + parent.parent);
        }
        if (parent.rightNode != null) {
            showTreeStrait(parent.rightNode);
        }

    }

    private Node<T> contains(T value, Node<T> parend) {
        while (parend != null) {
            if (parend.value.compareTo(value) == 0) {
                return parend;
            } else if (parend.value.compareTo(value) > 0) {
                if (parend.left == null) {
                    return null;
                }
                return contains(value, parend.left);
            } else if (parend.value.compareTo(value) < 0) {
                if (parend.rightNode == null) {
                    return null;
                }
                return contains(value, parend.rightNode);
            }
        }

        return null;
    }

    private void addTo(Node<T> parent, T value) {
        if (parent.value.compareTo(value) > 0) {
            if (parent.left == null) {
                parent.left = new Node<T>(value);
                parent.left.parent = parent;
            } else {
                addTo(parent.left, value);

            }
        } else {
            if (parent.rightNode == null) {
                parent.rightNode = new Node<T>(value);
                parent.rightNode.parent = parent;
            } else {
                addTo(parent.rightNode, value);
            }
        }
    }

    class Node<T> {

        T value;
        Node left;
        Node rightNode;
        Node parent;

        public Node(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

    }
}
