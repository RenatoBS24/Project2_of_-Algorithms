package Lists.Stack;

public class UndoRedo <E>{

    private final MyStack<E> stack1;
    private final MyStack<E> stack2;

    public UndoRedo() {
        stack1 = new MyStack<>();
        stack2 = new MyStack<>();
    }

    public void add(E item) {
        stack1.push(item);
        stack2.clear();
    }

    public E undo() throws Exception {
        if (stack1.size() > 1) {
            stack2.push(stack1.pop());
            return stack1.get(stack1.size() - 1);
        } else {
            return null;
        }
    }

    public E getCurrent() {
        if (stack1.isEmpty()) {
            return null;
        } else {
            return stack1.get(stack1.size() - 1);
        }
    }
}
