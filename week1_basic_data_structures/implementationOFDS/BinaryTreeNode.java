public class BinaryTreeNode<T> {
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private BinaryTreeNode<T> parent;

    public BinaryTreeNode(T value){
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(BinaryTreeNode<T> parent, T value){
        this.parent = parent;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
        this.left.parent = this;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setParent(BinaryTreeNode<T> parent) {
        this.parent = parent;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
        this.right.parent = this;
    }

    public void setRight(T val){
        this.right = new BinaryTreeNode<T>(this, val);
    }

    public void setLeft(T val){
        this.left = new BinaryTreeNode<T>(this, val);
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }
}