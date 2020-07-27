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

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>(5);
        tree.root.addChild(1);
        tree.root.addChild(2);
        tree.root.addChild(3);
        tree.root.addChild(4);
        tree.root.getChildren().valueOfIndex(2).result.addChild(31);;
        tree.root.getChildren().valueOfIndex(2).result.addChild(32);;
        tree.root.getChildren().valueOfIndex(2).result.addChild(33);;
        tree.root.getChildren().valueOfIndex(2).result.getChildren().valueOfIndex(2).result.addChild(331);
        tree.root.getChildren().valueOfIndex(2).result.getChildren().valueOfIndex(2).result.getChildren().valueOfIndex(0).result.addChild(3311);
        System.out.println(tree.height(tree.root));
    }
}