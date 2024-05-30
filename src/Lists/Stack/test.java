package Lists.Stack;

public class test {
    public static void main(String[] args) throws Exception {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(19);
        stack.push(15);
        stack.push(11);
        stack.push(18);
        stack.push(13);
        stack.push(10);
        stack.push(12);

        stack.pop();
        System.out.println();
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.get(i));
        }
    }
}
