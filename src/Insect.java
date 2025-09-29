package assignment1;

public abstract class Insect {

    private Tile position;
    private int health;

    public Insect(Tile position, int health){
        this.position = position;
        this.health = health

    }
    public final Tile  getPosition(){
        return position;
    }
    public final int getHealth(){
        return health;
    }
    public void setPosition(Tile t){
        this.position = t;
    }
}
