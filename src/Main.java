import java.util.Random;

public class Main {
    private static final int SIZE = 1000000;

    public static void main(String[] args) {
        MyArr arr = new MyArr(SIZE);
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr.insert(random.nextInt(5000));
        }
        long time = System.currentTimeMillis();
        int search = -10;
        System.out.println(arr.find(search) + " Linear search by " + (System.currentTimeMillis() - time) + " milliseconds");
        time = System.currentTimeMillis();
        System.out.println(arr.binaryFind(search) + " Binary search by " + (System.currentTimeMillis() - time) + " milliseconds");
        time = System.currentTimeMillis();
        arr.sortBubble();
        System.out.println("Bubble sort by " + (System.currentTimeMillis() - time) / 1000L + " seconds");
        time = System.currentTimeMillis();
        arr.sortSelect();
        System.out.println("Select sort by " + (System.currentTimeMillis() - time) / 1000L + " seconds");
        time = System.currentTimeMillis();
        arr.sortInsert();
        System.out.println("Insert sort by " + (System.currentTimeMillis() - time) + " milliseconds");
    }
}
