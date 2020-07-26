public class DoubleLinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoubleLinkedList(T val){
        DoubleNode<T> node = new DoubleNode<T>(val);
        this.head = node;
        this.tail = node;
    }

    public void pushFront(T val){
        DoubleNode<T> node = new DoubleNode<T>(val);
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

    public Response<T> topBack(){
        if (this.tail != null) {
            return new Response<T>("Success", this.tail.getValue());
        }else {
            return new Response<T>("Error");
        }
    }

    public Response<T> topFront(){
        if (this.head != null) {
            return new Response<T>("Success", this.head.getValue());
        }else {
            return new Response<T>("Error");
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

    public void pushBack(T val) {
        DoubleNode<T> node = new DoubleNode<T>(val);
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

    public DoubleNode<T> find(T val){
        DoubleNode<T> node = this.head;
        while (node != null) {
            if (node.getValue() == val) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void addAfter(DoubleNode<T> node, T val) {
        if (node == null) {
            return;
        }
        DoubleNode<T> newNode = new DoubleNode<T>(val);
        if (this.tail.equals(node)) {
            this.pushBack(val);
            return;
        }
        node.getNext().setPrev(newNode);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        newNode.setPrev(node);
    }

    public void addBefore(DoubleNode<T> node, T val) {
        if (node == null) {
            return;
        }
        DoubleNode<T> newNode = new DoubleNode<T>(val);
        if (this.head.equals(node)) {
            this.pushFront(val);
            return;
        }
        newNode.setNext(node);
        newNode.setPrev(node.getPrev());
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
    }

    public void erase(T val){
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
        DoubleNode<T> node = this.head;
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

    public boolean isEmpty(){
        return this.head == null && this.tail == null;
    }
}