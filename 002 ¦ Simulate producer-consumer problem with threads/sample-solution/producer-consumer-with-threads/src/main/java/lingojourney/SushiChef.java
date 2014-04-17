package lingojourney;

import static java.lang.Thread.sleep;

public class SushiChef implements Runnable {

    private final BlockingQueue<Sushi> belt;
    private String chefName;
    private int numberOfsushisToMake;

    public SushiChef(BlockingQueue<Sushi> belt, String chefName, int numberOfsushisToMake) {
        this.belt = belt;
        this.chefName = chefName;
        this.numberOfsushisToMake = numberOfsushisToMake;
    }

    public void run() {
        for (int i = 0; i < numberOfsushisToMake; i++) {
            System.out.println("Chef " + chefName + " about to put in a new sushi.");
            belt.enqueue(new Sushi(i));
            System.out.println("Chef " + chefName + " puts: " + i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException ignored) {
            }
        }
    }

}
