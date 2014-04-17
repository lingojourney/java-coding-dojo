package lingojourney;

/**
 * Created by benny on 18/04/2014.
 */
public interface IMiniBlockingQueue<T> {

    public T take() throws InterruptedException;

    public void put(T item) throws InterruptedException;
}
