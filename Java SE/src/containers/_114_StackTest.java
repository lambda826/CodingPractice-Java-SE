package containers;

public class _114_StackTest {
    public static void main(String[] args) {
        _113_Stack<String> stack = new _113_Stack<String>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}