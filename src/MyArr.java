public class MyArr {
    private int[] arr;
    private int size;
    private int min;
    private int max;

    public MyArr(int size) {
        this.size = 0;
        arr = new int[size];
    }

    public MyArr(int[] array) {
        size = array.length;
        arr = array;
        findMax();
        findMin();
    }

    private void findMax() {
        if (max == 0) max = arr[0];
        for (int i = 0; i < size; i++) {
            if (arr[i] > max) max = arr[i];
        }
    }

    public void findMin() {
        if (min == 0) min = arr[0];
        for (int i = 0; i < size; i++) {
            if (min < arr[i]) min = arr[i];
        }
    }

    public int length() {
        return arr.length;
    }

    public boolean binaryFind(int value) {
        int low = 0;
        int high = size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == arr[mid]) {
                return true;
            } else {
                if (value < arr[mid]) {
                    high = --mid;
                } else {
                    low = ++mid;
                }
            }
        }
        return false;
    }

    public boolean find(int value) {
        int i;
        for (i = 0; i < size; i++)
            if (arr[i] == value) return true;
        return false;
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public boolean deleteFirst(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                System.arraycopy(arr, i + 1, arr, i, --size - i);
                return true;
            }
        }
        return false;
    }

    /**
     * В случае удаления хотя бы одного элемента - true. Иначе false
     */

    public boolean deleteAll(int value) {
        boolean isDelete = false;
        while (deleteFirst(value)) isDelete = true;
        return isDelete;
    }

    public void deleteAll() {
        size = 0;
    }

    public void insert(int value) {
        checkLength();
        System.arraycopy(arr, 0, arr, 1, size++);
        arr[0] = value;
        checkMinMax(value);
    }

    public void insert(int value, int index) {
        checkLength();
        System.arraycopy(arr, index, arr, index + 1, size++ - index);
        arr[index] = value;
        checkMinMax(value);
    }

    private void checkMinMax(int value) {
        if (value < min) min = value;
        if (value > max) max = value;
    }

    /**
     * Проверка необходимости добавления длины массива и добавление путём создания нового
     */

    private void checkLength() {
        if (size == arr.length) {
            int[] temp = arr;
            arr = new int[arr.length * 2];
            System.arraycopy(temp, 0, arr, 0, size);
        }
    }

    /**
     * Меняем указанные элементы местами
     */

    private void change(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * Ходим по массиву и меняем 2 ближайших значения, меньшее влево - большее вправо.
     * Каждый следующий цикл последнее число справа - максимум, поэтому в следующем цикле его не используем.
     */

    public void sortBubble() {
        int out, in, count = 0;
        for (out = size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    change(in, in + 1);
                }
                count++;
            }
        }
        System.out.println("Bubble count: " + count);
    }

    /**
     * Находим минимальный элемент в массиве и меняем его с первым элементом. Далее идём ещё раз и меняем со вторым
     * и т д, пока не дойдём до конца массива
     */

    public void sortSelect() {
        int out, in, mark, count = 0;
        for (out = 0; out < size; out++) {
            mark = out;
            for (in = out + 1; in < size; in++) {
                if (arr[in] < arr[mark]) {
                    mark = in;
                }
                count++;
            }
            change(out, mark);
        }
        System.out.println("Select count: " + count);
    }

    /**
     * Стартуем со второго элемента и сравниваем его с ближайшим элементом слева. Далее двигаем его влево до тех пор,
     * пока его значение больше, чем элемент слева, либо до начала массива
     */

    public void sortInsert() {
        int in, out, count = 0;
        for (out = 1; out < size; out++) {
            int temp = arr[out];
            in = out;
            while (in > 0 && arr[in - 1] > temp) {
                arr[in] = arr[in - 1];
                --in;
                count++;
            }
            arr[in] = temp;
        }
        System.out.println("Insert count: " + count);
    }

    /**
     * Первый проход - создаём массив со значениями, указывающие количество повторений числа, равного индексу минус min.
     * Второй проход по полученному массиву - задаём новые значения на основе временного массива.
     */

    public void sortCount() {
        int index = 0, count = 0;
        int[] temp = new int[1 + max - min];
        for (int i = 0; i < size; i++) {
            temp[arr[i] - min]++;
            count++;
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = temp[i]; j > 0; j--) {
                arr[index++] = i + min;
                count++;
            }
        }
        System.out.println("Count sort: " + count);
    }
}
