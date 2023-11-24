package Sprite.Stationary;

import Interface.Direction;
import bagel.util.Point;

/**
 *  SignDown class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */

public class SignDown extends Sign {

    private static final String IMAGE_FILE = "res/images/down.png";
    private static final Direction DIRECTION = Direction.DOWN;

    public SignDown(Point position) {
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