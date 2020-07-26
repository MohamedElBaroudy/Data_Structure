public class Queue<T> {
    private DoubleLinkedList<T> queue;

    public Queue(){
        this.queue = new DoubleLinkedList<T>();
    }

    public void enqueue(T val){
        this.queue.pushBack(val);
    }

    public T dequeue(){
        T result = this.queue.topFront().result;
        this.queue.popFront();
        return result;
    }

    public boolean isEmpty(){
        return this.queue.isEmpty();
    }
}