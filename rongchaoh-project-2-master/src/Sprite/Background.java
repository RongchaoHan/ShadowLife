package Sprite;

// Import Packages
import bagel.Window;
import bagel.util.Point;

/**
 *  Sprite.Background class
 *  Contains the Sprite.Background information of the ShadowLife Game
 *  Created by Rongchao Han with ID: 1002758
 */

public class Background extends Sprite {

    // Constant
    private static final double BACKGROUND_X = Window.getWidth()/2.0;
    private static final double BACKGROUND_Y = Window.getHeight()/2.0;
    private static final String BACKGROUND_IMAGE = "res/images/background.png";

    public Background(){
        super(new Point(BACKGROUND_X,BACKGROUND_Y), BACKGROUND_IMAGE);
    }

    public void draw(){
        super.getImage().draw(super.getPosition().x,super.getPosition().y);
    }

    @Override
    protected boolean interact(Object object) {
        return false;
    }
}
