package lingojourney;


public class MeaningOfLife
{
    public final int meaningOfLife;
    private static MeaningOfLife instance;

    private static class HelperHolder {

        public static MeaningOfLife instance = new MeaningOfLife();
    }

    private MeaningOfLife() {
        meaningOfLife = 42;
    }

    public static MeaningOfLife getInstance() {
        return instance;
    }

    public int getMeaning() {
        return meaningOfLife;
    }
}
