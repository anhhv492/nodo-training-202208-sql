package collection2;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(26);
        stack.push(55);
        stack.push(42);
        stack.push(21);
        while (stack.hasNext()){
            System.out.println("data= "+stack.pop());
        }
    }
}
