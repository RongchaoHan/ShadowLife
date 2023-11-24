package Sprite.Stationary;

import Interface.Direction;
import bagel.util.Point;

/**
 *  Sign class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */
public abstract class Sign extends Stationary{

    private Direction direction;

    public Sign(Point position, String image, Direction direction) {
        super(position, image);

        this.direction = direction;
    }

    // Getters

    public Direction getDirection() {
        return direction;
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
