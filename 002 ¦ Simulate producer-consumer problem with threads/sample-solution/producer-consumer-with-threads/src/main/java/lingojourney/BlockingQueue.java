package lingojourney;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue<T> {

    private List<T> queue = new LinkedList<T>();
    private int limit = 10;

    public BlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized T dequeue() {
        while (queue.isEmpty() ) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        if (queue.size()== limit) {
            notifyAll();
        }
        return queue.remove(0);
    }

    public synchronized void enqueue(T item) {
        while (queue.size() == limit ) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        if (queue.isEmpty()) {
            notifyAll();
        }
        queue.add(item);
    }

}
