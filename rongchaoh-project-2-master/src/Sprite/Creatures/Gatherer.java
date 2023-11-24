package Sprite.Creatures;

// Import packages: local
import Sprite.Stationary.*;
import Interface.Direction;
import Sprite.Sprite;

// Import packages: library
import bagel.util.Point;


/**
 *  Gatherer class inherits from Creature class
 *  Describe the behaviours and information for Gatherer
 *  Handle all the situation when the gatherer interact with other sprite
 *  Created by Rongchao Han with ID: 1002758
 */
public class Gatherer extends Creature{

    // Constant
    private static final String IMAGE_FILE = "res/images/gatherer.png";
    private static final Direction INITIAL_DIRECTION = Direction.LEFT;

    /** Constructor for Gatherer
     *
     * @param position The initial position where gatherer is setting
     */
    public Gatherer(Point position) {
        super(position, IMAGE_FILE, INITIAL_DIRECTION);
    }

    /** Copy constructor for Gatherer
     *  The copy constructor is to copy the current information of an existing gatherer
     *  And create new Gatherer object by the copy constructor
     *
     * @param gatherer The reference of the copy target object
     * @param newDirection The resettable attribute of moving direction for new gatherer
     */
    public Gatherer(Gatherer gatherer, Direction newDirection) {
        super(gatherer.getPosition(), IMAGE_FILE, newDirection);
    }

    // Inheriting methods
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
                        changeDirection(rotate_180());
                    }

                // Interact with Stockpile
                }else if(sprite instanceof Stockpile){
                    Stockpile stockpile = (Stockpile) sprite;
                    if(getCarrying()){
                        super.stockFruit();
                        stockpile.stocked();
                    }
                    changeDirection(rotate_180());
                }
            }
        }
        return false;
    }

    // Local method
    private Direction rotate_180(){
        int currentDirection = super.getDirection().ordinal();
        if (currentDirection % 2 == 0 && currentDirection != 0)
            return Direction.values()[currentDirection - 1];
        else if (currentDirection % 2 == 1)
            return Direction.values()[currentDirection + 1];
        return null;
    }
}
