package lingojourney;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AlwaysFreshSushiShopTest extends TestCase {

    public void testApp() throws InterruptedException {
        BlockingQueue<Sushi> belt = new BlockingQueue<Sushi>(10);
        Thread chef = new Thread(new SushiChef(belt, "Taro", 25), "Taro");
        Thread customerN = new Thread(new SushiCustomer(belt, "Naruto", 10), "Naruto");
        Thread customerB = new Thread(new SushiCustomer(belt, "Sakura", 10), "Sakura");

        chef.start();
        customerN.start();
        customerB.start();

        chef.join();
        customerN.join();
        customerB.join();
    }
}
