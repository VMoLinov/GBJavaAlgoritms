public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        System.out.println("remove " + queue.remove());
        System.out.println("remove " + queue.remove());
        queue.insert(10);
        queue.insert(11);
        queue.insert(12);
        queue.insert(13);
        queue.insert(14);
        queue.insert(15);
        System.out.println(queue);
        Stack stack = new Stack(0);
        System.out.println(stack.pop());
    }
}

// public static void check(String input) {...}
