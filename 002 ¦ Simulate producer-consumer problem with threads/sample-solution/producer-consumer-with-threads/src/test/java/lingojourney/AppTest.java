package lingojourney;

import junit.framework.TestCase;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AppTest extends TestCase {

    public void test_using_custom_blocking_queue() throws InterruptedException {
        CustomBlockingQueue<Sushi> belt = new CustomBlockingQueue<>(10);
        Thread taro = new Thread(new SushiChef("Taro", 25, belt), "Taro");
        Thread naruto = new Thread(new SushiCustomer("Naruto", 10, belt), "Naruto");
        Thread sakura = new Thread(new SushiCustomer("Sakura", 10, belt), "Sakura");

        taro.start();
        naruto.start();
        sakura.start();

        taro.join(5000);
        naruto.join(5000);
        sakura.join(5000);
    }

    public void test_using_standard_blocking_queue() throws InterruptedException {
        IMiniBlockingQueue<Sushi> belt = new IMiniBlockingQueue<Sushi>() {

            private BlockingQueue<Sushi> queue = new LinkedBlockingQueue<>();

            @Override
            public Sushi take() throws InterruptedException {
                return queue.take();
            }

            @Override
            public void put(Sushi item) throws InterruptedException {
                queue.put(item);
            }
        };
        Thread taro = new Thread(new SushiChef("Taro", 25, belt), "Taro");
        Thread naruto = new Thread(new SushiCustomer("Naruto", 10, belt), "Naruto");
        Thread sakura = new Thread(new SushiCustomer("Sakura", 10, belt), "Sakura");

        taro.start();
        naruto.start();
        sakura.start();

        taro.join(5000);
        naruto.join(5000);
        sakura.join(5000);
    }

}
