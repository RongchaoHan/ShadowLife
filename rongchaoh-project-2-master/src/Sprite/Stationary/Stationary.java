package Sprite.Stationary;

// Import information
import bagel.util.Point;
import Sprite.Sprite;

/** Abstract Stationary class inherits from Sprite
 *  Describe the Object which stay still during the excute
 */
public abstract class Stationary extends Sprite {

    /** Constructor for Stationary
     *
     * @param position The initial position of the object
     * @param image The image file name of the object
     */
    public Stationary(Point position, String image) {
        super(position, image);
    }

    @Override
    public void draw(){
        super.draw();
    }
}
