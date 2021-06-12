public class BSTNode{
    private int val;
    private BSTNode leftNode;
    private BSTNode rightNode;
    private BSTNode parent;
    private int height = 0;

    public BSTNode(int val, BSTNode parent) {
        this.val = val;
        this.parent = parent;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BSTNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BSTNode leftNode) {
        this.leftNode = leftNode;
        if (leftNode != null)
            this.leftNode.parent = this;
    }

    public void setLeftNode(int val) {
        this.leftNode = new BSTNode(val, this);
    }

    public BSTNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BSTNode rightNode) {
        this.rightNode = rightNode;
        if (rightNode != null)
            this.rightNode.parent = this;
    }

    public void setRightNode(int val) {
        this.rightNode = new BSTNode(val, this);
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}