class Queue {
    private int maxSize;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public Queue(int size) {
        maxSize = size;
        queue = new int[maxSize];
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

    public void insert(int value) {
        if (isFull()) {
            ++maxSize;
            int[] tmpArr = new int[maxSize *= 2];
            if (tail >= head) {
                System.arraycopy(queue, 0, tmpArr, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
                System.arraycopy(queue, head, tmpArr,
                        maxSize - (queue.length - head), queue.length - head);
                head = maxSize - head - 1;
            }
            queue = tmpArr;
        }
        if (tail == maxSize - 1) tail = -1;
        queue[++tail] = value;
        ++items;
    }

    public int remove() {
        isEmpty();
        int temp = queue[head++];
        head %= maxSize;
        items--;
        return temp;
    }

    public int peek() {
        isEmpty();
        return queue[head];
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("[");
        for (int i = 0; i < maxSize; i++) {
            text.append(queue[i]);
            if (i < maxSize - 1) text.append(", ");
        }
        text.append("]");
        text.append(String.format(" head: %d, tail: %d, size: %d", head, tail, maxSize));
        return text.toString();
    }
}
