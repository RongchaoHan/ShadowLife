package Sprite.Stationary;

import bagel.util.Point;
import Sprite.Sprite;

/**
 *  Stockpile class inherits from Stationary class
 *  Contains the Image file and Override methods
 *  Created by Rongchao Han with ID: 1002758
 */
public class Stockpile extends Stationary  {

    private static final String IMAGE_FILE = "res/images/cherries.png";

    private int numberOfFruit = 0;
    private Fruit fruit;

    public Stockpile(Point position) {
        super(position, IMAGE_FILE);
        fruit = new Fruit(position, "" + numberOfFruit);
    }
    public Stockpile(Point position, String image) {
        super(position, image);
        fruit = new Fruit(position, "" + numberOfFruit);
    }

    // Setters
    public void stocked(){
        this.numberOfFruit++;
        fruit = new Fruit(fruit, ""+numberOfFruit);
    }
    public void theft() {
        this.numberOfFruit--;
        fruit = new Fruit(fruit, ""+numberOfFruit);
    }

    @Override
    public void draw(){
        if(fruit != null){
            fruit.draw();
        }
        super.draw();
    }

    @Override
    protected boolean interact(Object object) {
        return false;
    }

    public boolean isEmptyStockpile(){
        return numberOfFruit <= 0;
    }

    @Override
    public String toString(){
        return "" + numberOfFruit;
    }
}
