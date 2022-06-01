public class Main {

    public static void main(String[] args) {
//        testQueueAndStack();
        testDeck();
//        checkBracesInStack("(3)((4))(((5)))");
//        checkCharsEquality("(3)((4))(((5)))", '(', ')');
//        checkBracesInStack("(3)4))(((5)))");
//        checkCharsEquality("(3)4))(((5)))", '(', ')');
//        checkBracesInStack("(3)((4(((5)))");
//        checkCharsEquality("(3)((4(((5)))", '(', ')');
    }

    private static void testDeck() {
        Deck deck = new Deck(5);
        deck.insertFirst(1);
        deck.insertFirst(2);
        deck.insertLast(3);
        deck.insertLast(4);
        deck.insertLast(5);
        deck.insertFirst(6);
        System.out.println(deck);
        deck.getFirst();
        deck.getFirst();
        deck.getFirst();
        deck.getFirst();
        System.out.println(deck);
    }

    private static void checkBracesInStack(String text) {
        Stack stack = new Stack(text.length() / 2);
        try {
            for (int i = 0; i < text.length(); i++) {
                switch (text.charAt(i)) {
                    case '(' -> stack.push(i);
                    case ')' -> stack.pop();
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Не хватает открытых скобок");
            return;
        }
        if (stack.getHead() == -1) System.out.println("Все скобки на месте");
        else System.out.println("Не хватает закрытых скобок");
    }

    private static void checkCharsEquality(String text, char first, char second) {
        Stack stack = new Stack(text.length() / 2);
        try {
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (c == first) stack.push(i);
                else if (c == second) stack.pop();
            }
        } catch (RuntimeException e) {
            System.out.printf("Не хватает %c элементов%n", first);
            return;
        }
        if (stack.getHead() == -1) System.out.println("Проверка пройдена успешно");
        else System.out.printf("Не хватает %c элементов", second);
    }

    private static void testQueueAndStack() {
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
        Queue q = new Queue(0);
        q.insert(1);
        System.out.println(q);
//        Stack stack = new Stack(0);
//        System.out.println(stack.pop());
    }
}
