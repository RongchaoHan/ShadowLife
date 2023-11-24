package Sprite.Stationary;

import Interface.Direction;
import bagel.util.Point;

/**
 *  SignLeft class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */

public class SignLeft extends Sign {

    private static final String IMAGE_FILE = "res/images/left.png";
    private static final Direction DIRECTION = Direction.LEFT;

    public SignLeft(Point position) {
        super(position, IMAGE_FILE, DIRECTION);
    }

    @Override
    public void draw(){
        super.draw();
    }

    @Override
    protected boolean interact(Object object) {
        return false;
    }

}
