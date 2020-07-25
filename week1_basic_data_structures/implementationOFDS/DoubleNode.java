public class DoubleNode {
    private int value;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public int getValue() {
        return value;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(DoubleNode node) {
        return this.value == node.getValue() &&
         this.next == node.next &&
          this.prev == node.prev;
    }
}