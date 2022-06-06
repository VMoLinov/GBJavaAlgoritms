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

class Node {
    Cat cat;
    Node next;

    Node(Cat cat) {
        this.cat = cat;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void insert(Cat cat) {
        Node newNode = new Node(cat);
        if (isEmpty()) tail = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(Cat cat) {
        Node newNode = new Node(cat);
        if (isEmpty()) head = newNode;
        else tail.next = newNode;
        tail = newNode;
    }

    public String delete() {
        Node temp = head;
        if (head.next == null) tail = null;
        head = head.next;
        return temp.cat.name;
    }

    public String delete(String name) {
        Node current = head;
        Node previous = tail;
        while (!current.cat.name.equals(name)) {
            if (current.next == null) return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) head = head.next;
        else previous.next = current.next;
        return current.cat.name;
    }

    public Cat find(Cat cat) {
        Node current = head;
        while (current.cat != cat) {
            if (current.next == null) return null;
            else current = current.next;
        }
        return current.cat;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            current.cat.display();
            current = current.next;
        }
    }
}

class LinkIterator {
    private final LinkedList list;
    private Node current;
    private Node previous;

    public LinkIterator(LinkedList list) {
        this.list = list;
        this.reset();
    }

    public void reset() {
        current = list.getHead();
        previous = null;
    }

    public boolean hasNext() {
        return !(current.next == null);
    }

    public void nextNode() {
        previous = current;
        current = current.next;
    }

    public Node getCurrent() {
        return current;
    }

    public void insertAfter(Cat cat) {
        Node newNode = new Node(cat);
        if (list.isEmpty()) {
            list.setHead(newNode);
            current = newNode;
        } else {
            newNode.next = current.next;
            current.next = newNode;
            nextNode();
        }
    }

    public void insertBefore(Cat cat) {
        Node newNode = new Node(cat);
        if (previous == null) {
            newNode.next = list.getHead();
            list.setHead(newNode);
            reset();
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
            current = newNode;
        }
    }

    public String deleteCurrent() {
        Cat cat = current.cat;
        if (previous == null) {
            list.setHead(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (hasNext()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return cat.name;
    }

    public LinkIterator getIterator() {
        return new LinkIterator(list);
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

    public String delete(String name) {
        return queue.delete(name);
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
        System.out.printf("Элемент %s удалён из списка%n", queue.delete("Bubble"));
        queue.display();
    }
}
