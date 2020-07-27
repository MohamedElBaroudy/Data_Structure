public class TreeNode<T> {
    private T value;
    private DoubleLinkedList<TreeNode<T>> children;
    private TreeNode<T> parent;

    public TreeNode(T value){
        this.value = value;
        this.parent = null;
        this.children = new DoubleLinkedList<>();
    }

    public TreeNode(TreeNode<T> parent, T value){
        this.value = value;
        this.parent = parent;
        this.children = new DoubleLinkedList<>();
    }

    public DoubleLinkedList<TreeNode<T>> getChildren() {
        return children;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public void addChild(TreeNode<T> child){
        this.children.pushBack(child);
    }

    public void addChild(T value){
        this.children.pushBack(new TreeNode<T>(this, value));
    }
}