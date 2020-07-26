public class Stack<T> {
    private DoubleLinkedList<T> stack;

    public Stack(){
        this.stack = new DoubleLinkedList<T>();
    }

    public void push(T val){
        this.stack.pushBack(val);
    }

    public void pop(){
        if (!stack.isEmpty())
            this.stack.popBack();
    }
    
    public T top() {
        return this.stack.topBack().result;
    }

    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
}