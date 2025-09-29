package assignment1;

public class BusyBee extends HoneyBee {
    public static int BASE_HEALTH = 5;
    public static int BASE_COST = 3;
    public static int BASE_AMOUNT_COLLECTED = 2;

    public BusyBee(Tile position) {
        super(position, BASE_HEALTH, BASE_COST);
    }


    public boolean takeAction() {
        Tile pos = getPosition();
        if (pos == null) return false;
        pos.storeFood(BASE_AMOUNT_COLLECTED);
        return true;
    }
}