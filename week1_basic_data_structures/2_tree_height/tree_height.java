import java.util.*;
import java.io.*;

public class tree_height {

	public class Response<T> {
		public String message;
		public T result;
	
		public Response(String message, T result){
			this.message = message;
			this.result = result;
		}
	
		public Response(String message){
			this.message = message;
		}
	}

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

	public class TreeNode<T> {
		private T value;
		private DoubleLinkedList<TreeNode<T>> children;
		private TreeNode<T> parent;
	
		public TreeNode(T value){
			this.value = value;
			this.parent = null;
			this.children = new DoubleLinkedList<>();
		}
	
		public TreeNode(TreeNode<T> parent, T value){
			this.value = value;
			this.parent = parent;
			this.children = new DoubleLinkedList<>();
		}
	
		public DoubleLinkedList<TreeNode<T>> getChildren() {
			return children;
		}
	
		public TreeNode<T> getParent() {
			return parent;
		}
	
		public T getValue() {
			return value;
		}
	
		public void setValue(T value) {
			this.value = value;
		}
	
		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}
	
		public void addChild(TreeNode<T> child){
			child.parent = this;
			this.children.pushBack(child);
		}
	
		public void addChild(T value){
			this.children.pushBack(new TreeNode<T>(this, value));
		}
	}

	public class Tree<T>{
		private TreeNode<T> root;
		
		public Tree(T val){
			this.root = new TreeNode<T>(val);
		}
	
		public int height(TreeNode<T> node){
			if (node == null) {
				return 0;
			}
			int h = 0;
			for (int i = 0; i < node.getChildren().length(); i++) {
				int currentH = height(node.getChildren().valueOfIndex(i).result);
				if (currentH>h) {
					h = currentH;
				}
			}
			return h+1;
		}
	
		public int size(TreeNode<T> node){
			if (node == null) {
				return 0;
			}
			int h = 0;
			for (int i = 0; i < node.getChildren().length(); i++) {
				h += size(node.getChildren().valueOfIndex(i).result);
			}
			return h+1;
		}
	
		public TreeNode<T> getRoot() {
			return root;
		}
	}

    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		Tree<Integer> tree;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			tree = new Tree<>(in.nextInt());
			TreeNode<Integer> curNode = tree.getRoot();
			for (int i = 0; i < n-1; i++) {
				int k = in.nextInt();
				if (k != -1) {
					curNode.addChild(k);	
				}else {
					curNode.addChild(k);
					curNode = curNode.getChildren().topBack().result;
				}
			}
		}

		int computeHeight() {
			return tree.height(tree.getRoot());
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
