public class DoubleLinkedList {
    private DoubleNode head;
    private DoubleNode tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoubleLinkedList(int val){
        DoubleNode node = new DoubleNode(val);
        this.head = node;
        this.tail = node;
    }

    public void pushFront(int val){
        DoubleNode node = new DoubleNode(val);
        if (this.head == null) {
            this.head = node;
            this.tail = node;  
        }else {
            node.setNext(this.head);
            node.setPrev(null);
            this.head.setPrev(node);
            this.head = node;
        }
    }

    public void popFront(){
        if (this.head == null) {
            return;
        }else if (this.head.equals(this.tail)) {
            this.head = null;
            this.tail = null; 
        }else {
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
    }

    public void pushBack(int val) {
        DoubleNode node = new DoubleNode(val);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        }else {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }
    }

    public void popBack() {
        if (this.head == null) {
            return;
        }else if (this.head.equals(this.tail)) {
            this.head = null;
            this.tail = null;
        }else {
            this.tail= this.tail.getPrev();
            this.tail.setNext(null);
        }
    }

    public DoubleNode find(int val){
        DoubleNode node = this.head;
        while (node != null) {
            if (node.getValue() == val) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void addAfter(DoubleNode node, int val) {
        if (node == null) {
            return;
        }
        DoubleNode newNode = new DoubleNode(val);
        if (this.tail.equals(node)) {
            this.pushBack(val);
            return;
        }
        node.getNext().setPrev(newNode);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        newNode.setPrev(node);
    }

    public void addBefore(DoubleNode node, int val) {
        if (node == null) {
            return;
        }
        DoubleNode newNode = new DoubleNode(val);
        if (this.head.equals(node)) {
            this.pushFront(val);
            return;
        }
        newNode.setNext(node);
        newNode.setPrev(node.getPrev());
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
    }

    public void erase(int val){
        if (this.head == null) {
            return;
        }
        if (this.head.equals(this.tail) && this.head.getValue() == val){
            this.head = null;
            this.tail = null;
            return;
        }
        if (this.head.getValue() == val) {
            this.popFront();
            return;
        }
        DoubleNode node = this.head;
        while (node != null) {
            if (node.getValue() ==val){
                break;
            }
            node = node.getNext();
        }
        if (node.equals(this.tail)) {
            this.popBack();
            return;
        }
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.pushFront(1);
        linkedList.pushFront(2);
        linkedList.pushFront(3);
        linkedList.popFront();
        linkedList.popFront();
        linkedList.popFront();
        linkedList.pushBack(1);
        linkedList.pushBack(2);
        linkedList.pushBack(3);
        // linkedList.popBack();
        // linkedList.popBack();
        // linkedList.popBack();
        linkedList.addAfter(linkedList.find(3), 4);
        // linkedList.addAfter(linkedList.find(2), 22);
        // linkedList.addAfter(linkedList.find(1), 11);
        linkedList.addAfter(linkedList.find(5), 55);
        linkedList.addBefore(linkedList.find(1), 0);
        // linkedList.addBefore(linkedList.find(4), 33);
        // linkedList.addBefore(linkedList.find(3), 22);
        linkedList.erase(0);
        linkedList.erase(4);
        linkedList.erase(2);
        linkedList.erase(3);
        linkedList.erase(1);
        System.out.println("hi");
    }
}