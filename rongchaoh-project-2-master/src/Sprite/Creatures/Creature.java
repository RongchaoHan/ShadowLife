package Sprite.Creatures;

// Import packages: local
import bagel.util.Point;
import Interface.Direction;
import Sprite.Sprite;

// Import packages: library
import java.util.ArrayList;

/**
 *  Abstract Creature class inherits from Sprite class
 *  Contains inherited information
 *  Describe the common attributes for subclasses
 *  Created by Rongchao Han with ID: 1002758
 */
public abstract class Creature extends Sprite{

    // Constants
    private static final int TILE = 64;

    // Attributes
    private Direction direction;
    private boolean carrying = false;
    private boolean active = true;
    private boolean back = false;

    // Static Attributes
    public static ArrayList<Creature> copyList = new ArrayList<>();
    public static ArrayList<Creature> destroyList = new ArrayList<>();

    /** Constructor for Creature class
     *
     * @param position The position of new creature
     * @param image The image file name of the new creature
     * @param direction The initial moving direction of the new creature
     */
    Creature(Point position, String image, Direction direction) {
        super(position, image);
        this.direction = direction;
    }

    // Getters
    Direction getDirection() {
        return direction;
    }
    boolean getCarrying(){ return this.carrying; }
    public boolean isActive(){ return active; }

    // Setters
    void inactive(){
        this.active = false;
    }
    void changeDirection(Direction newDirection){
        this.direction = newDirection;
    }
    void carryFruit(){
        if(!carrying) {
            this.carrying = true;
        }
    }
    void stockFruit(){
        this.carrying = false;
    }

    // Methods inherited from superclass
    @Override
    public void draw(){
        super.draw();
    }

    @Override
    protected boolean interact(Object object){
        if(object == null){
            return false;
        }
        Sprite sprite = (Sprite) object;
        return super.getPosition().equals(sprite.getPosition());
    }

    @Override
    protected void move(Point newPosition) {
        if(active) {
            super.move(newPosition);
        }else{
            Point backPosition = null;
            if(!back){
                super.move(nextPosition());
                back = true;
            }
        }
    }

    /* Copy method move()
     *  This method is to break the inheritance of method during the continuous inheriting
     *  The following move method will be public and inherited to subclasses
     */
    public void move(){
        move(nextPosition());
    }

    // Static method for updating the copy list when copy object
    static void copy(Creature creature) {

        if (creature != null) {
            if (creature instanceof Gatherer) {
                Gatherer gatherer = (Gatherer) creature;
                switch (creature.getDirection()) {

                    case SHUTDOWN:
                        break;

                    case LEFT:
                    case RIGHT:
                        copyList.add(new Gatherer(gatherer, Direction.UP));
                        copyList.add(new Gatherer(gatherer, Direction.DOWN));

                        break;

                    case UP:
                    case DOWN:
                        copyList.add(new Gatherer(gatherer, Direction.LEFT));
                        copyList.add(new Gatherer(gatherer, Direction.RIGHT));
                        break;


                }
            }
        }
    }

    // Local method nextPosition: to get next position of a tick of moving
    private Point nextPosition(){
        Point newPosition = null;
        switch (this.direction)
        {
            case SHUTDOWN:
                break;
            case LEFT:
                newPosition = new Point(super.getPosition().x - TILE,
                        super.getPosition().y);
                break;
            case RIGHT:
                newPosition = new Point(super.getPosition().x + TILE,
                        super.getPosition().y);
                break;
            case UP:
                newPosition = new Point(super.getPosition().x,
                        super.getPosition().y - TILE);
                break;
            case DOWN:
                newPosition = new Point(super.getPosition().x,
                        super.getPosition().y + TILE);
                break;
        }
        return newPosition;
    }





}
