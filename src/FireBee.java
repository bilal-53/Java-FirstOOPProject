package assignment1;

public class FireBee extends HoneyBee {
    private int attackRange;
    public static int BASE_HEALTH = 4;
    public static int BASE_COST = 5;

    public FireBee(Tile position, int attackRange) {
        super(position, BASE_HEALTH, BASE_COST);
        this.attackRange = attackRange;
    }

    public int getAttackRange() { return attackRange; }

    @Override
    public boolean takeAction() {
        // TODO: If on path, scan toward the nest within attackRange and set the first tile
        // containing hornets on fire (but not own tile). Return true if tile set on fire.
        return false;
    }
}
