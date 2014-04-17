package lingojourney;

import org.apache.log4j.Logger;

public class SushiCustomer implements Runnable {
    private final String customerName;
    private final int numberOfSushisToEat;
    private final IMiniBlockingQueue<Sushi> sushiBelt;
    private static Logger log = Logger.getLogger(SushiChef.class);

    public SushiCustomer(String customerName, int numberOfSushisToEat, IMiniBlockingQueue<Sushi> sushiBelt) {
        this.customerName = customerName;
        this.numberOfSushisToEat = numberOfSushisToEat;
        this.sushiBelt = sushiBelt;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfSushisToEat; i++) {
            try {
                log.info("Customer #" + customerName + " ready to eat a new sushi");
                Sushi sushi = sushiBelt.take();
                log.info("Customer #" + customerName + " has eaten sushi " + sushi);
            } catch (InterruptedException ignored) {
            }
        }
    }

}
