package assignment1;

public class AngryBee extends HoneyBee {
    private int attackDamage;
    public static int BASE_HEALTH = 4;
    public static int BASE_COST = 2;

    public AngryBee(Tile position, int attackDamage) {
        super(position, BASE_HEALTH, BASE_COST);
        this.attackDamage = attackDamage;
    }

    public int getAttackDamage() { return attackDamage; }

    @Override
    public boolean takeAction() {
        // TODO: Find non-empty swarm on same tile or next tile toward nest and sting first hornet.
        // Placeholder implementation returns false.
        return false;
    }
}
