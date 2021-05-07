package binary_search_tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySeachTree <E extends Comparable<? super E>> {
    TreeNode<E> root;
    private List<String> lst = new LinkedList<String>();

    public BinarySeachTree(TreeNode<E> root) {
        this.root = root;
    }

    private boolean addNode(E value, TreeNode<E> parent) {
        int comp = value.compareTo(parent.getValue());
        if(comp < 0) {
            if(parent.getLeft() != null) {
                return addNode(value, parent.getLeft());
            } else {
                parent.addLeftChild(value);
                return true;
            }
        } else if (comp > 0) {
            if (parent.getRight() != null) {
                return addNode(value, parent.getRight());
            } else {
                parent.addRightChild(value);
                return true;
            }
        } else return false;
    }

    public boolean addNode(E value) {
        int comp = value.compareTo(root.getValue());
        if(comp < 0 ) {
            if(root.getLeft() != null) {
                return addNode(value, root.getLeft());
            } else {
                root.addLeftChild(value);
                return true;
            }
        } else if(comp > 0) {
            if(root.getRight() != null) {
                return addNode(value, root.getRight());
            } else {
                root.addRightChild(value);
                return true;
            }
        } else return false;
    }

    /**
     * Visit yourself
     * Visit all your left subtree
     * Visit all your right subtree
     * ABCDEFG
     */
    private void preOrder(TreeNode<E> node) {
        if(node != null) {
            node.visit();
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }

    /**
     * Visit yourself
     * Visit all your left subtree
     * Visit all your right subtree
     * ABCDEFG
     */
    public void preOrder() {
        preOrder(this.root);
    }

    /**
     * Post order traversal
     * Visit all of your left subtree
     * Visit all of your right subtree
     * Visit yourself
     */
    public void postOrder() {
        postOrder(this.root);
    }
    public void postOrder(TreeNode<E> node) {
        if(node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            node.visit();
        }
    }

    /**
     * In order traversal
     * Visit all of your left subtree
     * Visit yourself
     * Visit all of your right subtree
     */
    public void inOrder() {
        inOrder(this.root);
    }

    public void inOrder(TreeNode<E> node) {
        if(node != null) {
            inOrder(node.getLeft());
            node.visit();
            inOrder(node.getRight());
        }
    }

    /**
     * Level order traversal
     */
    public void levelOrder() {
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode<E> curr = q.remove();
            if(curr != null) {
                curr.visit();
                q.add(curr.getLeft());
                q.add(curr.getRight());
            }
        }
    }

    /**
     * Searching in a Binary Search Tree
     * @param element
     */
    public boolean toFind(E element) {
        return toFind(this.root, element);
    }

    public boolean toFind(TreeNode<E> node, E element) {
        if(node != null) {
            int comp = element.compareTo(node.getValue());
            if(comp == 0) return true;
            else if(comp < 0) return toFind(node.getLeft(), element);
            else return toFind(node.getRight(), element);
        } else return false;
    }

    /**
     * Removing an element from a Binary Search Tree
     * @param element
     */
    public boolean remove(E element) {
        return remove(this.root, element);
    }

    public boolean remove(TreeNode<E> node, E element) {
        if(node != null) {
            int comp = element.compareTo(node.getValue());
            if(comp == 0) {
                int comp2 = element.compareTo(this.root.getValue());
                TreeNode<E> nodeChange;
                if(comp2 >= 0) {
                    nodeChange = removeBiggestElement(node);
                } else {
                    nodeChange = removeSmallestElement(node);
                }
                node.setValue(nodeChange.getValue());
                return true;
            } else if(comp < 0) {
                return remove(node.getLeft(), element);
            } else {
                return remove(node.getRight(), element);
            }
        } else return false;
    }

    private TreeNode<E> removeBiggestElement(TreeNode<E> node) {
        TreeNode<E> right = node.getRight();
        if(right != null) {
            return removeBiggestElement(right);
        } else {
            TreeNode<E> res = new TreeNode<>(node.getValue(), null);
            node.getParent().setRight(null);
            return res;
        }
    }

    private TreeNode<E> removeSmallestElement(TreeNode<E> node) {
        TreeNode<E> left = node.getLeft();
        if(left != null) {
            return removeSmallestElement(left);
        } else {
            TreeNode<E> res = new TreeNode<>(node.getValue(), null);
            node.getParent().setLeft(null);
            return res;
        }
    }

    public static void main(String [] args) {
//        TreeNode<String> root = new TreeNode<String>("D", null);
//        BinarySeachTree<String> bst = new BinarySeachTree<String>(root);
//        bst.addNode("J");
//        bst.addNode("K");
//        bst.addNode("E");
//        bst.addNode("A");
//        bst.addNode("B");
//        bst.addNode("C");
//        // bst.preOrder();
//        // bst.postOrder();
//        // bst.inOrder();
//        // bst.levelOrder();
//        String element = "E";
//        if(bst.toFind(element)) System.out.println("Hurray, we found element: " + element +  " in the Tree");
//        else System.out.println("Wow, we didn't find element: " +  element +  " in the Tree");

        TreeNode<Integer> root = new TreeNode<Integer>(50, null);
        BinarySeachTree<Integer> bst = new BinarySeachTree<Integer>(root);
        bst.addNode(40);
        bst.addNode(60);
        bst.addNode(30);
        bst.addNode(45);
        bst.addNode(55);
        bst.addNode(70);

        bst.addNode(35);
        bst.addNode(25);
        bst.addNode(42);
        bst.addNode(47);

        bst.addNode(52);
        bst.addNode(57);
        bst.addNode(65);
        bst.addNode(75);
//        TreeNode<Integer> big =  bst.removeBiggestElement(bst.root);
//        System.out.println("We have removed the biggest element in the tree: " + big.getValue());
//        TreeNode<Integer> small =  bst.removeSmallestElement(bst.root);
//        System.out.println("We have removed the smallest element in the tree: " + small.getValue());
        //bst.remove(50);
        // bst.remove(40);
        // bst.remove(60);
        // bst.remove(55);
        bst.remove(45);
        bst.levelOrder();
    }
}
