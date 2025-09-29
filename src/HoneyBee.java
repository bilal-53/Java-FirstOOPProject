package assignment1;

public abstract class HoneyBee extends Insect {
    private int cost;
    public static double HIVE_DMG_REDUCTION = 0.5; // example default (50%); adjust as needed

    public HoneyBee(Tile position, int health, int cost) {
        super(position, health);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }


    public void takeDamage(int damage) {
        Tile pos = getPosition();
        int reduced = damage;
        if (pos != null && pos.isHive()) {
            double reducedD = damage * (1.0 - HIVE_DMG_REDUCTION);
            // round toward 0
            reduced = (int) (reducedD);
        }
        super.takeDamage(reduced);
    }
}
