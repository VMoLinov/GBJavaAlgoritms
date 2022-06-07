import java.util.Random;
import java.util.TreeSet;

public class Main {
    private static final int SIZE_X = 8;
    private static final int SIZE_Y = 8;
    private static final int MOVES_VARIANTS = 8;
    private static final int[][] table = new int[SIZE_X][SIZE_Y];
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println(degree(3, 16));
        System.out.println(degree(2, 14));
        horseInit(1, 1);
//        horseInit(2, 2);
        printGrid();
        System.out.println(checkNumbers().size());
    }

    static int degree(int number, int pow) {
        return degree(number, pow, 1);
    }

    static int degree(int number, int pow, int result) {
        result *= number;
        if (--pow == 0) return result;
        else return degree(number, pow, result);
    }

    private static TreeSet<Integer> checkNumbers() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                treeSet.add(table[i][j]);
            }
        }
        return treeSet;
    }

    static void printGrid() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%4d", table[i][j]);
            }
            System.out.println();
        }
    }

    static void horseInit(int x, int y) {
        move(--x, --y, 1);
    }

    static void move(int x, int y, int count) {
        if (count < 30) {
            table[x][y] = count;
            Directions dir = Directions.values()[random.nextInt(MOVES_VARIANTS)];
            while (!correctCoordinates(x, y, dir)) {
                dir = Directions.values()[random.nextInt(MOVES_VARIANTS)];
            }
            move(x + dir.x, y + dir.y, ++count);
        }
    }

    private static boolean correctCoordinates(int x, int y, Directions dir) {
        return x + dir.x > 0 && x + dir.x < SIZE_X && y + dir.y > 0 && y + dir.y < SIZE_Y &&
                table[x + dir.x][y + dir.y] == 0;
    }
}

enum Directions {
    UP_LEFT(0, -1, -2),
    UP_RIGHT(1, 1, -2),
    RIGHT_UP(2, 2, -1),
    RIGHT_DOWN(3, 2, 1),
    DOWN_RIGHT(4, 1, 2),
    DOWN_LEFT(5, -1, 2),
    LEFT_DOWN(6, -2, 1),
    LEFT_UP(7, -2, -1);
    final int value;
    final int x;
    final int y;

    Directions(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }
}
