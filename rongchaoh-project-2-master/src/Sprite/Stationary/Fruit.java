package Sprite.Stationary;

import bagel.Font;
import bagel.util.Point;

public class Fruit{

    private static final String FONT_FILE = "res/VeraMono.ttf";

    private Font font = new Font(FONT_FILE,15);
    private String text;
    private Point position;

    // Getters
    private Point getPosition(){
        return this.position;
    }

    public Fruit(Point position, String text) {
        this.position = position;
        this.text = text;
    }

    public Fruit(Fruit fruit, String text){
        this.position = fruit.getPosition();
        this.text = text;
    }

    public void draw(){
        font.drawString(text, position.x, position.y);
    }


}
