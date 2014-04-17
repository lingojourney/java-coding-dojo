package lingojourney;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomBlockingQueue<T> implements IMiniBlockingQueue<T> {

    private final List<T> items = new LinkedList<>();
    private final int capacity;

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public synchronized void put(T item) throws InterruptedException {
        while (items.size() == capacity) {
            wait();
        }
        if (items.isEmpty()) {
            notifyAll();
        }
        items.add(item);
    }

    @Override
    public synchronized T take() throws InterruptedException {
        while (items.isEmpty()) {
            wait();
        }
        if (items.size() == capacity) {
            notifyAll();
        }
        return items.remove(0);
    }

}
