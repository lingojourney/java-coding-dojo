package lingojourney;

public class Sushi {
    private String sushiId;

    @Override
    public String toString() {
        return "Sushi{" +
                "sushiId='" + sushiId + '\'' +
                '}';
    }

    public Sushi(String sushiId) {
        this.sushiId = sushiId;
    }
}
