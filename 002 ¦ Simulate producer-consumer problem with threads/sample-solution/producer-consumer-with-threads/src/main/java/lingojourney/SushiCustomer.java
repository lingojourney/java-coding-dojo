package lingojourney;

public class SushiCustomer implements Runnable {

    private final BlockingQueue<Sushi> belt;
    private final int numberOfSushisToEat;
    private String customerName;

    public SushiCustomer(BlockingQueue<Sushi> belt, String customerName, int numberOfSushisToEat) {
        this.belt = belt;
        this.customerName = customerName;
        this.numberOfSushisToEat = numberOfSushisToEat;
    }

    public void run() {
        for (int i = 0; i < numberOfSushisToEat; i++) {
            System.out.println("Customer #" + customerName + " about to fetch for a new sushi.");
            Sushi sushi = belt.dequeue();
            System.out.println("Customer #" + customerName + " got: " + sushi);
        }
    }
}
