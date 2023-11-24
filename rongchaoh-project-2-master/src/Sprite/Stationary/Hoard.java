package Sprite.Stationary;

import bagel.util.Point;
import Sprite.Sprite;

/**
 *  Hoard class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */
public class Hoard extends Stockpile{

    private static final String IMAGE_FILE = "res/images/hoard.png";

    public Hoard(Point position) {
        super(position, IMAGE_FILE);
    }

    // Setters
    public void stocked(){
        super.stocked();
    }
    public void theft() { super.theft(); }

    @Override
    public void draw(){
        super.draw();
    }

    @Override
    protected boolean interact(Object object) {
        return false;
    }

    public boolean isEmptyHoard(){
        return super.isEmptyStockpile();
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
