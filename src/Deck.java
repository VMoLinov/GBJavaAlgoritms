public class Deck {
    private int maxSize;
    private int[] deck;
    private int head;
    private int tail;
    private int items;

    public Deck(int size) {
        maxSize = size;
        deck = new int[maxSize];
        head = 0;
        tail = -1;
        items = 0;
    }

    public void isEmpty() {
        if (items == 0) throw new RuntimeException("Queue is empty");
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void insertLast(int value) {
        if (isFull()) {
            ++maxSize;
            int[] tmpArr = new int[maxSize *= 2];
            if (tail >= head) {
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

    public void insertFirst(int value) {
        if (isFull()) {
            ++maxSize;
            int[] tmpArr = new int[maxSize *= 2];
            if (tail >= head) {
                System.arraycopy(deck, 0, tmpArr, 0, deck.length);
            } else {
                System.arraycopy(deck, 0, tmpArr, 0, tail + 1);
                System.arraycopy(deck, head, tmpArr,
                        maxSize - (deck.length - head), deck.length - head);
                head = maxSize - head + 1;
            }
            deck = tmpArr;
        }
        if (head == 0) head = maxSize;
        deck[--head] = value;
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
