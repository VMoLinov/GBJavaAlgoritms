public class Deck {
    private int maxSize;
    private int[] deck;
    private int head;
    private int tail;
    private int items;

    public Deck(int size) {
        maxSize = size;
        deck = new int[maxSize];
        head = maxSize / 2; // Начнём идти с серидины массива. При добавлении элементов у head будет ПОСТдекремент
        tail = maxSize / 2; // у tail - ПРЕинкремент. В таком случае ячейки не перезатрут друг друга
        items = 0;
    }

    public void isEmpty() {
        if (items == 0) throw new RuntimeException("Deck is empty");
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    /**
     * Логика добавления такая же, как у очереди, если нужно добавить размер - добавляем пространство либо влева от head,
     * либо вправо от tail, либо между head и tail в зависимости от ситуации
     */

    public void insertFirst(int value) {
        if (isFull()) {
            ++maxSize; // На случай, если инициализирована дека с размером 0
            int[] tmpArr = new int[maxSize *= 2];
            if (tail > head) {
                System.arraycopy(deck, 0, tmpArr, maxSize - deck.length, deck.length);
            } else {
                System.arraycopy(deck, 0, tmpArr, 0, tail + 1);
                System.arraycopy(deck, head, tmpArr,
                        maxSize - (deck.length - head), deck.length - head);
                head = maxSize - (deck.length - head);
            }
            deck = tmpArr;
        }
        deck[head--] = value;
        if (head == -1) head = maxSize - 1;
        ++items;
    }

    public void insertLast(int value) {
        if (isFull()) {
            ++maxSize;
            int[] tmpArr = new int[maxSize *= 2];
            if (tail > head) {
                System.arraycopy(deck, 0, tmpArr, 0, deck.length);
            } else {
                System.arraycopy(deck, 0, tmpArr, 0, tail + 1);
                System.arraycopy(deck, head, tmpArr,
                        maxSize - (deck.length - head), deck.length - head);
                head = maxSize - head - 1;
            }
            deck = tmpArr;
        }
        if (tail == maxSize - 1) tail = -1;
        deck[++tail] = value;
        ++items;
    }

    public int getFirst() {
        isEmpty();
        int temp = deck[head++];
        head %= maxSize;
        items--;
        return temp;
    }

    public int getLast() {
        isEmpty();
        items--;
        if (tail == 0) tail = maxSize;
        return deck[tail--];
    }

    public int peekFirst() {
        isEmpty();
        return deck[head];
    }

    public int peekLast() {
        isEmpty();
        return deck[tail];
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("[");
        for (int i = 0; i < maxSize; i++) {
            text.append(deck[i]);
            if (i < maxSize - 1) text.append(", ");
        }
        text.append("]");
        text.append(String.format(" head: %d, tail: %d, size: %d", head, tail, maxSize));
        return text.toString();
    }
}
