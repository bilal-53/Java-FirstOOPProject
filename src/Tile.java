package assignment1;


public class Tile {
    private int food;
    private boolean isHive;
    private boolean isNest;
    private boolean onThePath;
    private Tile towardTheHive;
    private Tile towardTheNest;
    private HoneyBee bee;
    private SwarmOfHornets swarm;
    private boolean onFire;


    public Tile() {
        this.food = 0;
        this.isHive = false;
        this.isNest = false;
        this.onThePath = false;
        this.towardTheHive = null;
        this.towardTheNest = null;
        this.bee = null;
        this.swarm = new SwarmOfHornets();
        this.onFire = false;
    }


    public Tile(int food, boolean isHive, boolean isNest, boolean onThePath,
                Tile towardTheHive, Tile towardTheNest,
                HoneyBee bee, SwarmOfHornets swarm, boolean onFire) {
        this.food = food;
        this.isHive = isHive;
        this.isNest = isNest;
        this.onThePath = onThePath;
        this.towardTheHive = towardTheHive;
        this.towardTheNest = towardTheNest;
        this.bee = bee;
        this.swarm = (swarm == null ? new SwarmOfHornets() : swarm);
        this.onFire = onFire;
    }

    public boolean isHive() { return isHive; }
    public boolean isNest() { return isNest; }
    public void buildHive() { isHive = true; }
    public void buildNest() { isNest = true; }
    public boolean isOnThePath() { return onThePath; }
    public Tile towardTheHive() { return towardTheHive; }
    public Tile towardTheNest() { return towardTheNest; }

    /**
     * Make this tile part of the path, providing next tiles toward hive and toward nest.
     * If towardHive/towardNest is null it is allowed only if this tile is an extremity (hive/nest).
     */
    public void createPath(Tile towardHive, Tile towardNest) {
        // Validate: if towardHive == null but this is not a hive, it's invalid.
        if (towardHive == null && !this.isHive) {
            throw new IllegalArgumentException("Null towardHive only allowed when this tile is the hive.");
        }
        if (towardNest == null && !this.isNest) {
            throw new IllegalArgumentException("Null towardNest only allowed when this tile is the nest.");
        }
        this.towardTheHive = towardHive;
        this.towardTheNest = towardNest;
        this.onThePath = true;
    }

    public int collectFood() {
        int tmp = this.food;
        this.food = 0;
        return tmp;
    }

    public void storeFood(int amount) {
        if (amount < 0) return;
        this.food += amount;
    }

    public int getNumOfHornets() {
        return this.swarm == null ? 0 : this.swarm.sizeOfSwarm();
    }

    public HoneyBee getBee() {
        return this.bee;
    }

    public Hornet getHornet() {
        return (this.swarm == null) ? null : this.swarm.getFirstHornet();
    }

    public Hornet[] getHornets() {
        return (this.swarm == null) ? new Hornet[0] : this.swarm.getHornets();
    }

    /**
     * Adds an insect to this tile following the rules:
     * - A bee can be added only if there is no bee on the tile and the tile is not a nest.
     * - Hornets can only be placed on tiles that are on the path (including hive and nest).
     * If added successfully, the insect's position is updated to this tile.
     * Returns true if added, false otherwise.
     */
    public boolean addInsect(Insect insect) {
        if (insect == null) return false;

        if (insect instanceof HoneyBee) {
            // bees cannot be placed on nest and there can be only one bee per tile
            if (this.isNest) return false;
            if (this.bee != null) return false;
            this.bee = (HoneyBee) insect;
            insect.setPosition(this);
            return true;
        } else if (insect instanceof Hornet) {
            // hornets can only be on the path (including hive and nest)
            if (!this.onThePath) return false;
            if (this.swarm == null) this.swarm = new SwarmOfHornets();
            this.swarm.addHornet((Hornet) insect);
            insect.setPosition(this);
            return true;
        } else {
            // unknown insect type
            return false;
        }
    }

    /**
     * Remove an insect from this tile. Uses reference equality for comparison.
     * If removed, the insect's position is set to null.
     */
    public boolean removeInsect(Insect insect) {
        if (insect == null) return false;
        if (insect instanceof HoneyBee) {
            if (this.bee == insect) {
                this.bee = null;
                insect.setPosition(null);
                return true;
            } else {
                return false;
            }
        } else if (insect instanceof Hornet) {
            if (this.swarm == null) return false;
            boolean removed = this.swarm.removeHornet((Hornet) insect);
            if (removed) {
                insect.setPosition(null);
            }
            return removed;
        } else {
            return false;
        }
    }

    public void setOnFire() { this.onFire = true; }
    public boolean isOnFire() { return this.onFire; }
}