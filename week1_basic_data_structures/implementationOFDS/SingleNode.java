/**
 * SingleNode
 */
public class SingleNode <T>{

    private T value;
    private SingleNode<T> next;

    public SingleNode(T value){
        this.value = value;
        this.next = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }

    public boolean equals(SingleNode<T> node) {
        return this.value == node.getValue() && this.next == node.next;
    }
}