public class Tree<T>{
    private TreeNode<T> root;
    
    public Tree(T val){
        this.root = new TreeNode<T>(val);
    }

    public int height(TreeNode<T> node){
        if (node == null) {
            return 0;
        }
        int h = 0;
        for (int i = 0; i < node.getChildren().length(); i++) {
            int currentH = height(node.getChildren().valueOfIndex(i).result);
            if (currentH>h) {
                h = currentH;
            }
        }
        return h+1;
    }

    public int size(TreeNode<T> node){
        if (node == null) {
            return 0;
        }
        int h = 0;
        for (int i = 0; i < node.getChildren().length(); i++) {
            h += size(node.getChildren().valueOfIndex(i).result);
        }
        return h+1;
    }
}