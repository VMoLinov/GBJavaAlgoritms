import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArr arr = new MyArr(new int[]{9, 2, 3, 3, 4, 4, 5});
        MyArr array = new MyArr(SIZE);
        init(array);
        System.out.println("array has 5: " + array.find(5));
        System.out.println("array deleted 3: " + array.deleteAll(3));
        System.out.println("array has 10: " + array.binaryFind(10));
        array.display();
        arr.insert(8, 5);
        arr.display();
        array.sortBubble();
        array.display();
        array = new MyArr(SIZE);
        init(array);
        array.sortSelect();
        array.display();
        array = new MyArr(SIZE);
        init(array);
        array.sortInsert();
        array.display();
        array.deleteAll();
        init(array);
        array.sortCount();
        array.display();
    }

    private static void init(MyArr array) {
        Random random = new Random();
        for (int i = 0; i < array.length(); i++) {
            array.insert(random.nextInt(50) - 25);
        }
    }

    private static final int SIZE = 50;
}
