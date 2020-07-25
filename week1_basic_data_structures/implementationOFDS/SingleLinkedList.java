import java.lang.Exception;
/**
 * DolaLinkedList
 */
public class SingleLinkedList {
    private SingleNode head;
    private SingleNode tail;
    
    public SingleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public SingleLinkedList(int val) {
        SingleNode node = new SingleNode(val);
        this.head = node;
        this.tail = node;
    }

    public void pushFront(int val) {
        SingleNode node = new SingleNode(val);
        node.setNext(this.head);
        this.head = node;
        if (this.tail == null) {
            this.tail = node;
        }
    }

    public void pushBack(int val) {
        SingleNode node = new SingleNode(val);
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        }else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void popFront() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.getNext();
        if (this.head == null) {
            this.tail = null;
        }
    }

    public void popBack(){
        if (this.tail == null) {
            return;
        }

        if (this.head.equals(this.tail)) {
            this.head = null;
            this.tail = null;
            return;
        }
        SingleNode node = this.head;
    
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }

        node.setNext(null);
        this.tail = node;
    }

    public void addAfter(SingleNode node, int val) {
        SingleNode newNode = new SingleNode(val);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        if (this.tail.equals(node)) {
            this.tail = newNode;
        }
    }

    public void addBefore(SingleNode node, int val){
        if (this.head.equals(node)) {
            this.pushFront(val);
            return;
        }
        SingleNode currentNode = this.head;
        while (currentNode.getNext() != node) {
            currentNode = currentNode.getNext();
        }

        SingleNode newNode = new SingleNode(val);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }

    public SingleNode find(int val) {
        if (this.head == null) {
            return null;
        }

        SingleNode node = this.head;
        while (node != null) {
            if (node.getValue() == val) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void erase(int val){
        if (this.head == null) {
            return;
        }
        if (this.head.equals(this.tail) ) {
            if (this.head.getValue() == val){
                this.head = null;
                this.tail = null;
                return;
            }else {
                return;
            }
        }

        if (this.head.getValue() == val) {
            this.popFront();
            return;
        }

        SingleNode node = this.head;
        while (node.getNext() != null) {
            if (node.getNext().getValue() == val) {
                if (node.getNext().equals(this.tail)) {
                    this.popBack();
                    return;
                }
                node.setNext(node.getNext().getNext());
            }
            node = node.getNext();
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.pushFront(1);
        linkedList.pushFront(2);
        linkedList.pushFront(3);
        // linkedList.popFront();
        linkedList.pushFront(4);
        linkedList.pushBack(5);
        // linkedList.popBack();
        linkedList.addAfter(linkedList.find(5), 6);
        linkedList.addBefore(linkedList.find(4), 0);
        linkedList.addBefore(linkedList.find(2), -2);
        linkedList.erase(0);
        linkedList.erase(6);
        linkedList.erase(-2);
        linkedList.erase(4);
        linkedList.erase(2);
        linkedList.erase(3);
        linkedList.erase(1);
        linkedList.erase(5);
        System.out.println("hi");
    }
}