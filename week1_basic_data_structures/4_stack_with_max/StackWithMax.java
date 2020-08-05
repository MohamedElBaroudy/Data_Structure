import java.util.*;
import java.io.*;

public class StackWithMax {

    public class Stack {
        Vector<Integer> vector;
    
        public Stack(){
            this.vector = new Vector<>();
        }
    
        public void push(int val){
            this.vector.add(val);
        }
    
        public void pop(){
            if (!vector.isEmpty())
                this.vector.remove(vector.size()-1);
        }

        public int max(){
            return Collections.max(vector);
        }
        
        public int top() {
            return this.vector.get(vector.size()-1);
        }
    
        public boolean isEmpty(){
            return this.vector.isEmpty();
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

    public void solve() throws IOException {
        FastScanner scanner = new FastScanner();
        int queries = scanner.nextInt();
        Stack stack = new Stack();

        for (int qi = 0; qi < queries; ++qi) {
            String operation = scanner.next();
            if ("push".equals(operation)) {
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(operation)) {
                stack.pop();
            } else if ("max".equals(operation)) {
                System.out.println(stack.max());
            }
        }
    }

    static public void main(String[] args) throws IOException {
        new StackWithMax().solve();
    }
}
