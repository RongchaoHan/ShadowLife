package Sprite.Creatures;

import Sprite.Sprite;
import Sprite.Stationary.*;
import bagel.util.Point;
import Interface.Direction;

/**
 *  Thief class inherits from Creature class
 *  Describe the behaviours and information for Thief
 *  Handle all the situation when the thief interact with other sprite
 *  Created by Rongchao Han with ID: 1002758
 */
public class Thief extends Creature{

    // Constant
    private static final String IMAGE_FILE = "res/images/thief.png";
    private static final Direction INITIAL_DIRECTION = Direction.UP;

    // Unique Attribute: only for thief
    private boolean consuming = false;

    /** Constructor for Thief
     *
     * @param position The initial position where thief is setting
     */
    public Thief(Point position) {
        super(position, IMAGE_FILE, INITIAL_DIRECTION);
    }

    /** Copy constructor for Thief
     *  The copy constructor is to copy the current information of an existing thief
     *  And create new Thief object by the copy constructor
     *
     * @param thief The reference of the copy target object
     * @param newDirection The resettable attribute of moving direction for new thief
     */
    public Thief(Thief thief, Direction newDirection) {
        super(thief.getPosition(), IMAGE_FILE, newDirection);
    }

    // Inheriting Methods
    @Override
    public void draw(){
        super.draw();
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    void changeDirection(Direction newDirection){
        super.changeDirection(newDirection);
    }

    // Overloading method of changeDirection: To determine the new direction of the current situation
    public boolean changeDirection(Object object){
        if(object != null){
            Sprite sprite = (Sprite) object;
            if(super.interact(sprite)) {

                // Interact with Fence
                if (sprite instanceof Fence) {
                    changeDirection(rotate_180());
                    super.inactive();
                    return true;

                // Interact with Pool
                }else if(sprite instanceof Pool){
                    Creature.copy(this);
                    return true;

                // Interact with Sign
                }else if(sprite instanceof Sign){
                    Sign sign = (Sign) object;
                    changeDirection(sign.getDirection());

                // Interact with Tree
                }else if(sprite instanceof Tree){
                    Tree tree = (Tree) sprite;
                    if(!tree.isEmptyTree() && !getCarrying()) {
                        tree.gathered();
                        super.carryFruit();
                    }

                }else if(sprite instanceof Stockpile) {
                    Stockpile stockpile = (Stockpile) sprite;

                    // Interact with Hoard
                    if (sprite instanceof Hoard) {
                        Hoard hoard = (Hoard) sprite;
                        if (consuming) {
                            this.consuming = false;
                            if (!getCarrying()) {
                                if (!hoard.isEmptyHoard()) {
                                    carryFruit();
                                    hoard.theft();
                                } else {
                                    rotateClockWise_90();
                                }
                            }
                        } else if (getCarrying()) {
                            stockFruit();
                            hoard.stocked();
                            rotateClockWise_90();
                        }

                        // Interact with Stockpile
                    } else {
                        if (!getCarrying()) {
                            if (!stockpile.isEmptyStockpile()) {
                                carryFruit();
                                this.consuming = false;
                                stockpile.theft();
                                rotateClockWise_90();
                            }
                        } else {
                            rotateClockWise_90();
                        }
                    }

                // Interact with Pad
                }else if (sprite instanceof Pad) {
                    this.consuming = true;

                // Interact with Gatherer
                }else if (sprite instanceof Gatherer) {
                    rotateAntiClockWise_90();
                }
            }
        }
        return false;
    }

    private void rotateClockWise_90(){
        switch (super.getDirection()){
            case SHUTDOWN:
                break;
            case LEFT:
                changeDirection(Direction.UP);
                break;
            case RIGHT:
                changeDirection(Direction.DOWN);
                break;
            case UP:
                changeDirection(Direction.RIGHT);
                break;
            case DOWN:
                changeDirection(Direction.LEFT);
                break;
        }
    }
    private Direction rotate_180(){
        int currentDirection = super.getDirection().ordinal();
        if (currentDirection % 2 == 0 && currentDirection != 0)
            return Direction.values()[currentDirection - 1];
        else if (currentDirection % 2 == 1)
            return Direction.values()[currentDirection + 1];
        return null;
    }
    private void rotateAntiClockWise_90(){
        switch (getDirection()) {
            case SHUTDOWN:
                break;
            case LEFT:
                changeDirection(Direction.DOWN);
                break;
            case RIGHT:
                changeDirection(Direction.UP);
                break;
            case UP:
                changeDirection(Direction.LEFT);
                break;
            case DOWN:
                changeDirection(Direction.RIGHT);
                break;
        }
    }
}
