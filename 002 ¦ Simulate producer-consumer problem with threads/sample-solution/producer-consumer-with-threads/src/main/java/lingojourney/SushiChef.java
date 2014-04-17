package lingojourney;

import org.apache.log4j.Logger;

public class SushiChef implements Runnable {

    private final String chefName;
    private final int numberOfSushisToMake;
    private final IMiniBlockingQueue<Sushi> sushiBelt;
    private static Logger log = Logger.getLogger(SushiChef.class);

    public SushiChef(String chefName, int numberOfSushisToMake, IMiniBlockingQueue<Sushi> sushiBelt) {
        this.chefName = chefName;
        this.numberOfSushisToMake = numberOfSushisToMake;
        this.sushiBelt = sushiBelt;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfSushisToMake; i++) {
            try {
                log.info("Chef #" + chefName + " ready to put in a new sushi");
                sushiBelt.put(new Sushi("" + i));
                log.info("Chef #" + chefName + " has put in sushi " + i);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
