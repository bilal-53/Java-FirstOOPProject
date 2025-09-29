package assignment1;

public class Hornet extends Insect {
    private int attackDamage;
    public static int BASE_FIRE_DMG = 1; // baseline; assignment step 4 will use this
    private boolean isTheQueen = false;
    private static int numOfQueens = 0;

    public Hornet(Tile position, int health, int attackDamage) {
        super(position, health);
        this.attackDamage = attackDamage;
    }

    public int getAttackDamage() { return attackDamage; }

    public boolean isTheQueen() { return isTheQueen; }

    public void promote() {
        if (!isTheQueen && numOfQueens == 0) {
            isTheQueen = true;
            numOfQueens++;
        }
    }


    public boolean takeAction() {
        // TODO: implement sting or move forward
        // NOTE: skeleton returns true as placeholder.
        return true;
    }


    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof Hornet)) return false;
        Hornet other = (Hornet) o;
        return this.attackDamage == other.attackDamage;
    }
}

