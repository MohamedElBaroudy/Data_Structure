public class BST {
    private BSTNode root;

    public BST(int val) {
        this.root = new BSTNode(val,null);
    }

    public BSTNode find(int val, BSTNode node){
        if (node.getVal() == val)
            return node;
        else if (val < node.getVal())
        {
            if (node.getLeftNode() != null)
                return find(val, node.getLeftNode());
            return node;
        }
        else //if (val > node.getVal())
        {
            if (node.getRightNode() != null)
                return find(val, node.getRightNode());
            return node;
        }
    }

    private BSTNode next(BSTNode node){
        if (node.getRightNode() != null)
            return leftDescendant(node.getRightNode());
        else
            return rightAncestor(node);
    }

    private BSTNode leftDescendant(BSTNode node){
        while(node.getLeftNode() != null){
            node = node.getLeftNode();
        }
        return node;
    }

    private BSTNode rightAncestor(BSTNode node){
        while(node.getParent().getVal() < node.getVal()){
            node = node.getParent();
        }
        return node.getParent();
    }

    private void normalInsert(int val){
        BSTNode node = find(val, this.root);
        if (val < node.getVal()){
            node.setLeftNode(val);
        }else if (val > node.getVal()){
            node.setRightNode(val);
        }
    }

    private BSTNode insert(BSTNode node, int val){
        if (node == null){
            return new BSTNode(val, null);
        }

        if (val < node.getVal()) {
            node.setLeftNode(insert(node.getLeftNode(), val));
        } else if (val > node.getVal()){
            node.setRightNode(insert(node.getRightNode(), val));
        } else {
            return node;
        }

        return balance(node);
    }

    public void AVLInsert(int val){
        this.root = insert(this.root, val);
    }

    private void normalDelete(int val){
        BSTNode node = find(val, this.root);
        if (node.getVal() != val)
            return;
        if (node.getRightNode() != null){
            BSTNode nextNode = next(node);
            // promote the next node right node as it's the most left child
            nextNode.getParent().setLeftNode(nextNode.getRightNode());
            //if (nextNode.getRightNode() != null){
            //  nextNode.getRightNode().setParent(nextNode.getParent()); implemented
            //}
            // remove next node parent pointer
            nextNode.setParent(null);
            // exchange the next node with our node
            if (node.getVal() == node.getParent().getLeftNode().getVal()){
                node.getParent().setLeftNode(nextNode);
            }else if (node.getVal() == node.getParent().getRightNode().getVal()){
                node.getParent().setRightNode(nextNode);
            }
            nextNode.setLeftNode(node.getLeftNode());
            nextNode.setRightNode(node.getRightNode());

        }else{
            if (node.getLeftNode() == null){
                if (node.getVal() == node.getParent().getLeftNode().getVal()){
                    node.getParent().setLeftNode(null);
                    //node.setParent(null); implemented
                }else if (node.getVal() == node.getParent().getRightNode().getVal()){
                    node.getParent().setRightNode(null);
                    //node.setParent(null); implemented
                }
            }else {
                if (node.getVal() == node.getParent().getLeftNode().getVal()){
                    node.getParent().setLeftNode(node.getLeftNode());
                    //node.getLeftNode().setParent(node.getParent()); implemented
                    node.setLeftNode(null);
                    node.setParent(null);
                }else if (node.getVal() == node.getParent().getRightNode().getVal()){
                    node.getParent().setRightNode(node.getLeftNode());
                    //node.getLeftNode().setParent(node.getParent()); implemented
                    node.setLeftNode(null);
                    node.setParent(null);
                }
            }
        }
    }

    private BSTNode delete(BSTNode node, int val){
        if (node == null)
            return null;
        if (val < node.getVal()){
            node.setLeftNode(delete(node.getLeftNode(), val));
        } else if (val > node.getVal()){
            node.setRightNode(delete(node.getRightNode(), val));
        } else
        {

            // node with only one child or no child
            if ((node.getLeftNode() == null) || (node.getRightNode() == null))
            {
                BSTNode temp = null;
                if (temp == node.getLeftNode())
                    temp = node.getRightNode();
                else
                    temp = node.getLeftNode();

                // No child case
                if (temp == null)
                {
                    node = null;
                }
                else // One child case
                    node.setVal(temp.getVal()); // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the next node (smallest in the right subtree)
                BSTNode temp = next(node);

                // Copy the next node's data to this node
                node.setVal(temp.getVal());

                // Delete the next node
                node.setRightNode(delete(node.getRightNode(), temp.getVal()));
            }
        }

        if (node == null)
            return node;

        return balance(node);
    }

    public void AVLDelete(int val){
        this.root = delete(this.root, val);
    }

    private BSTNode rotateRight(BSTNode node) {
        BSTNode leftTemp = node.getLeftNode();

        node.setLeftNode(leftTemp.getRightNode());
        leftTemp.setRightNode(null);
        leftTemp.setParent(null);
        leftTemp.setRightNode(node);

        node.setHeight(1 + Math.max(
                getHeight(node.getLeftNode()),
                getHeight(node.getRightNode())
        ));
        leftTemp.setHeight(1 + Math.max(
                getHeight(leftTemp.getLeftNode()),
                getHeight(leftTemp.getRightNode())
        ));

        return leftTemp;
    }

    private BSTNode rotateLeft(BSTNode node) {
        BSTNode rightTemp = node.getRightNode();

        node.setRightNode(rightTemp.getLeftNode());
        rightTemp.setParent(null);
        rightTemp.setLeftNode(null);
        rightTemp.setLeftNode(node);

        node.setHeight(1 + Math.max(
                getHeight(node.getLeftNode()),
                getHeight(node.getRightNode())
        ));
        rightTemp.setHeight(1 + Math.max(
                getHeight(rightTemp.getLeftNode()),
                getHeight(rightTemp.getRightNode())
        ));

        return rightTemp;
    }

    private BSTNode rotateLeftRight(BSTNode node) {
        node.setLeftNode(rotateLeft(node.getLeftNode()));

        return rotateRight(node);
    }

    private BSTNode rotateRightLeft(BSTNode node) {
        node.setRightNode(rotateRight(node.getRightNode()));

        return rotateLeft(node);
    }

    private int getHeight(BSTNode node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private int getBalance(BSTNode node) {
        if (node == null) {
            return 0;
        }

        return getHeight(node.getLeftNode()) - getHeight(node.getRightNode());
    }

    private BSTNode balance(BSTNode node){
        node.setHeight(1+ Math.max(getHeight(node.getRightNode()), getHeight(node.getLeftNode())));

        int balance = getBalance(node);

        if (balance > 1){
            if (getBalance(node.getLeftNode()) >= 0)
                node = rotateRight(node);
            else
                node = rotateLeftRight(node);
        }else if (balance < -1){
            if (getBalance(node.getRightNode()) <= 0)
                node = rotateLeft(node);
            else
                node = rotateRightLeft(node);
        }

        return node;
    }
}