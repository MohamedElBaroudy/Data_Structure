public class DoubleNode<T> {
    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    public DoubleNode(T value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public T getValue() {
        return value;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean equals(DoubleNode<T> node) {
        return this.value == node.getValue() &&
         this.next == node.next &&
          this.prev == node.prev;
    }
}