/**
 * DolaLinkedList
 */
public class SingleLinkedList<T> {
    private SingleNode<T> head;
    private SingleNode<T> tail;
    
    public SingleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public SingleLinkedList(T val) {
        SingleNode<T> node = new SingleNode<T>(val);
        this.head = node;
        this.tail = node;
    }

    public void pushFront(T val) {
        SingleNode<T> node = new SingleNode<T>(val);
        node.setNext(this.head);
        this.head = node;
        if (this.tail == null) {
            this.tail = node;
        }
    }

    public void pushBack(T val) {
        SingleNode<T> node = new SingleNode<T>(val);
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        }else {
            this.tail.setNext(node);
            this.tail = node;
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
        SingleNode<T> node = this.head;
    
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }

        node.setNext(null);
        this.tail = node;
    }

    public void addAfter(SingleNode<T> node, T val) {
        SingleNode<T> newNode = new SingleNode<T>(val);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        if (this.tail.equals(node)) {
            this.tail = newNode;
        }
    }

    public void addBefore(SingleNode<T> node, T val){
        if (this.head.equals(node)) {
            this.pushFront(val);
            return;
        }
        SingleNode<T> currentNode = this.head;
        while (currentNode.getNext() != node) {
            currentNode = currentNode.getNext();
        }

        SingleNode<T> newNode = new SingleNode<T>(val);
        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);
    }

    public SingleNode<T> find(T val) {
        if (this.head == null) {
            return null;
        }

        SingleNode<T> node = this.head;
        while (node != null) {
            if (node.getValue() == val) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    public void erase(T val){
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

        SingleNode<T> node = this.head;
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
}