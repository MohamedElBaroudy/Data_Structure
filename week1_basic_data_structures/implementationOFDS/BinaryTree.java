public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree(T value){
        this.root = new BinaryTreeNode<T>(value);
    }

    public void inOrderTraversal(BinaryTreeNode<T> node){
        /**
         * Depth First
         */
        if (node == null) {
            return;
        }
        inOrderTraversal(node.getLeft());
        System.out.println(node.getValue());
        inOrderTraversal(node.getRight());
    }

    public void preOrderTraversal(BinaryTreeNode<T> node){
        /**
         * Depth First
         */
        if (node == null) {
            return;
        }

        System.out.println(node.getValue());
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void postOrderTraversal(BinaryTreeNode<T> node){
        /**
         * Depth First
         */
        if (node == null) {
            return;
        }
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.println(node.getValue());
    }

    public void levelTraversal(BinaryTreeNode<T> node){
        /**
         * Breadth First
         */
        if (node == null) {
            return;
        }
        Queue<BinaryTreeNode<T>> queue = new Queue<>();
        queue.enqueue(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> curTreeNode = queue.dequeue();
            System.out.println(curTreeNode.getValue());
            if (curTreeNode.getLeft()!=null) {
                queue.enqueue(curTreeNode.getLeft());
            }
            if (curTreeNode.getRight()!=null) {
                queue.enqueue(curTreeNode.getRight());
            }
        }
    }

    public int height(BinaryTreeNode<T> node){
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public int size(BinaryTreeNode<T> node){
        if (node == null) {
            return 0;
        }

        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(T value) {
        this.root = new BinaryTreeNode<T>(value);
    }
}