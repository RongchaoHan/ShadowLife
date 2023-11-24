package Sprite.Stationary;

import bagel.util.Point;
import Sprite.Sprite;

/**
 *  GoldenTree class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */
public class GoldenTree extends Tree {

    // Constant
    private static final String IMAGE_FILE = "res/images/gold-tree.png";
    private final int numberOfFruit = Integer.MAX_VALUE;

    /** Constructor for the Golden tree
     *
     * @param position the initial position of the new golden tree
     */
    public GoldenTree(Point position) {
        super(position, IMAGE_FILE);
    }

    @Override
    public void draw(){
        super.draw();
    }

    @Override
    protected boolean interact(Object object) {
        return false;
    }

    @Override
    public boolean isEmptyTree(){
        return numberOfFruit <= 0;
    }

    @Override
    public void gathered(){ }
}
