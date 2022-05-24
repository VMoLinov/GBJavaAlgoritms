public class Main {

    public static void main(String[] args) {
        System.out.println(toDegree(5, 3));
        System.out.println(toDegree(6, 1));
        System.out.println(toDegreeSquare(6, 2));
        System.out.println(toDegreeSquare(7, 4));
        System.out.println(toDegreeSquareAdd(6, 2));
        System.out.println(toDegreeSquareAdd(7, 4));
        System.out.println(calculateRow(0, 140));
        System.out.println(calculateRow(150, 200));
        System.out.println(calculateRowFaster(1, 140));
        System.out.println(calculateRowFaster(150, 200));
    }

    private static int toDegree(int number, int pow) { // O(n)
        if (pow == 0) return 0;
        else {
            int num = 1;
            for (int i = 0; i < pow; i++) num *= number;
            return num;
        }
    }

    private static int toDegreeSquare(int number, int pow) { // O(n)
        if (pow % 2 != 0) return toDegree(number, pow);
        else return calculatePow(number, pow);
    }

    private static int toDegreeSquareAdd(int number, int pow) { // O(log(n))
        if (pow % 2 == 0) return calculatePow(number, pow);
        else return calculatePow(number, pow - 1) * number;
    }

    private static int calculatePow(int n, int p) {
        while (p != 1) {
            n *= n;
            p /= 2;
        }
        return n;
    }

    private static int calculateRow(int from, int to) { // O(n)
        int acc = 0;
        for (int i = from; i <= to; i++) acc += i;
        return acc;
    }

    private static int calculateRowFaster(int from, int to) { // O(1)
        if (from <= 1) return to * (to + 1) / 2; // n * (n + 1) / 2
        else return to * (to + 1) / 2 - from * (from - 1) / 2;
    }
}
