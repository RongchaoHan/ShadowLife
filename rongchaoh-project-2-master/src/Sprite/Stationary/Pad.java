package Sprite.Stationary;

import bagel.util.Point;
import Sprite.*;


/**
 *  Pad class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */

public class Pad extends Stationary {

    private static final String IMAGE_FILE = "res/images/pad.png";

    public Pad(Point position) {
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

}
