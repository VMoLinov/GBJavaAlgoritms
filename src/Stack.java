class Stack {
    private int maxSize;
    private int[] stack;
    private int head;

    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        head = -1;
    }

    public int getHead() {
        return head;
    }

    public void isEmpty() {
        if (head == -1) throw new RuntimeException("Stack is empty");
    }

    public boolean isFull() {
        return head == maxSize - 1;
    }

    public void push(int value) {
        if (isFull()) {
            ++maxSize;
            int[] newStack = new int[maxSize *= 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
        stack[++head] = value;
    }

    public int pop() {
        isEmpty();
        return stack[head--];
    }

    public int peek() {
        isEmpty();
        return stack[head];
    }
}
