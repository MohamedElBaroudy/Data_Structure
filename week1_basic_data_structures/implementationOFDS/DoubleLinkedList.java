public class DoubleLinkedList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int size;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoubleLinkedList(T val){
        DoubleNode<T> node = new DoubleNode<T>(val);
        this.head = node;
        this.tail = node;
        this.size = 1;
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
        this.size++;
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
        this.size--;
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
        this.size++;
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
        this.size--;
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
        this.size++;
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
        this.size++;
    }

    public void erase(T val){
        if (this.head == null) {
            return;
        }
        if (this.head.equals(this.tail) && this.head.getValue() == val){
            this.head = null;
            this.tail = null;
            this.size--;
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
        this.size--;
    }

    public Response<T> valueOfIndex(int index){
        if (index >= this.size) {
            return new Response<>("failed");
        }
        int i = 0;
        DoubleNode<T> node = this.head;
        while (node != null) {
            if (i == index) {
                return new Response<>("succed", node.getValue());
            }
            node = node.getNext();
            i++;
        }
        return new Response<>("failed");
    }

    public boolean isEmpty(){
        return this.head == null && this.tail == null;
    }

    public int length() {
        return size;
    }
}