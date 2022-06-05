class Node {
    public Cat cat;
    public Node next;

    public Node(Cat cat) {
        this.cat = cat;
    }
}

class Cat {
    String name;
    int age;

    Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.printf("Name: %s, age: %d%n", name, age);
    }
}

class LinkedList {
    public Node head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insert(Cat cat) {
        Node newNode = new Node(cat);
        newNode.next = head;
        head = newNode;
    }

    public String delete() {
        Node temp = head;
        head = head.next;
        return temp.cat.name;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            current.cat.display();
            current = current.next;
        }
    }
}

class Queue {
    private final LinkedList queue;

    public Queue() {
        queue = new LinkedList();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void insert(Cat cat) {
        queue.insert(cat);
    }

    public String delete() {
        return queue.delete();
    }

    public void display() {
        queue.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Cat cat1 = new Cat("Barsik", 1);
        Cat cat2 = new Cat("Murzik", 2);
        Cat cat3 = new Cat("Bubble", 3);
        Cat cat4 = new Cat("Nick", 4);
        queue.insert(cat1);
        queue.insert(cat2);
        queue.insert(cat3);
        queue.insert(cat4);
        queue.display();
        while (!queue.isEmpty()) {
            System.out.printf("Элемент %s удалён из очереди%n", queue.delete());
        }
    }
}