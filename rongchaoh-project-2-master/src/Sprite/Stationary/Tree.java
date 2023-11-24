package Sprite.Stationary;

// Import information
import bagel.util.Point;

/**
 *  Tree class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */
public class Tree extends Stationary {

    // Constant
    private static final String IMAGE_FILE = "res/images/tree.png";

    // Attributes
    private int numberOfFruit = 3;
    private Fruit fruit;

    /** Constructor for Tree
     *
     * @param position The initial position for a new Tree
     */
    public Tree(Point position) {
        super(position, IMAGE_FILE);
        fruit = new Fruit(position, "" + numberOfFruit);
    }

    /** Overloading Constructor for Golden Tree
     *
     * @param position The initial position for a new golden tree
     * @param image The image file name for the golden tree
     */
    public Tree(Point position, String image) {
        super(position, image);
    }

    // Getters
    public boolean isEmptyTree(){
        return numberOfFruit <= 0;
    }

    // Setters
    public void gathered(){
        this.numberOfFruit--;
        fruit = new Fruit(fruit, ""+numberOfFruit);
    }

    @Override
    public void draw(){
        if(fruit != null){
            fruit.draw();
        }
        super.draw();
    }

    @Override
    protected boolean interact(Object object) {
        return false;
    }




}
