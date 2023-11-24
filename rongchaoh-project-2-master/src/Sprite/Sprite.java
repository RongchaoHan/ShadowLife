package Sprite;

// Import Packages:
import bagel.Window;
import bagel.util.Point;
import bagel.Image;

/**
 *  Abstract Sprite class
 *  The Conclusion of all actors in the ShadowLife Game
 *  Stores the Common Attributes and Methods for All the subclasses
 *  With its functionality and property instance
 *  Created by Rongchao Han with ID: 1002758
 */
public abstract class Sprite {

    // Common Attributes for Sprites
    private Point position;
    private Image image;

    // Getters
    public Point getPosition(){
        return this.position;
    }
    public Image getImage(){ return this.image; }

    /** Constructor for Sprite class
     *
     * @param position The initial position of a sprite in the Game Window
     * @param image The image file name of the new sprite object
     */
    public Sprite (Point position, String image){
        this.position = position;
        this.image = new Image(image);
    }

    // Common methods
    public void draw(){
        this.image.drawFromTopLeft(position.x, position.y);
    }

    protected void move(Point newPosition){
        if(isValidMove(newPosition)){
            this.position = newPosition;
        }
    }

    protected abstract boolean interact(Object object);

    // Local method isValidMove: Check if the object move outside the Window
    private boolean isValidMove(Point newPosition){
        return  newPosition.x >= 0 &&
                newPosition.y >= 0 &&
                newPosition.x <= Window.getWidth() &&
                newPosition.y <= Window.getHeight();
    }



}
