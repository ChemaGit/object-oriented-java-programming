package binary_search_tree;

import javax.security.auth.login.CredentialException;

public class TreeNode<E>{
    private E value;
    private TreeNode<E> parent;
    private TreeNode<E> left;
    private TreeNode<E> right;
    private boolean visit = false;

    public TreeNode(E val, TreeNode<E> par) {
        this.value = val;
        this.parent = par;
        this.left = null;
        this.right = null;
    }

    public void visit() {
        System.out.println(value);
    }

    public boolean getVisit() {
        return this.visit;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public void setRight(TreeNode<E> node) {
        this.right = node;
    }

    public void setLeft(TreeNode<E> node) {
        this.left = node;
    }

    public TreeNode<E> addLeftChild(E val) {
        this.left = new TreeNode<E>(val, this);
        return this.left;
    }

    public TreeNode<E> addRightChild(E val) {
        this.right = new TreeNode<E>(val, this);
        return this.right;
    }

    public E getValue() {
        return value;
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }
}
