package assignment1;


public class SniperBee extends HoneyBee {
    private int attackDamage;
    private int piercingPower;
    private boolean isAiming = false; // toggles each turn
    public static int BASE_HEALTH = 3;
    public static int BASE_COST = 6;

    public SniperBee(Tile position, int attackDamage, int piercingPower) {
        super(position, BASE_HEALTH, BASE_COST);
        this.attackDamage = attackDamage;
        this.piercingPower = piercingPower;
    }


    public boolean takeAction() {
        // TODO: If not on path return false.
        // If aiming this turn, switch out of aiming and return true/false accordingly.
        // If shooting this turn, damage up to piercingPower hornets in the first non-empty swarm found.
        // Placeholder: toggles and returns false.
        isAiming = !isAiming;
        return !isAiming; // returns true only when shooting (placeholder)
    }
}