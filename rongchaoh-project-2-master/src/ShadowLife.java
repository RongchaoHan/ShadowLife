
// Import Packages: local
import Sprite.Creatures.*;
import Sprite.Stationary.*;
import Sprite.*;
import Sprite.Creatures.Gatherer;
import util.World;

// Import Packages: library
import bagel.AbstractGame;
import bagel.Input;
import java.util.ArrayList;



/**
 *  ShadowLife class
 *  Contains the Setting instances and Setting method of the game
 *  Run and update the elements of the game
 *  Created by Rongchao Han with ID: 1002758
 */
public class ShadowLife extends AbstractGame{

    // Constants
    private static final int WINDOW_SIZE_X = 1024, WINDOW_SIZE_Y = 768;
    private static final int STATIONARY = 1;
    private static final int GATHERER = 2;
    private static final int THIEF = 3;

    // Objects
    private ArrayList[] characters;
    private static String worldFile;

    // Tick control objects
    private static int tickRate;
    private static int maxTick;
    private static long moveStd;
    private int currentTick;

    /** Constructor for ShadowLife
     *  Set the Window of the Game
     *  Read the world file and current tick
     */
    private ShadowLife(){
        super(WINDOW_SIZE_X, WINDOW_SIZE_Y, "ShadowLife - Completed Version");

        World world = new World(worldFile);
        characters = world.getCharacters();
        moveStd = System.currentTimeMillis();
        currentTick = 0;
    }

    /**
     * Performs a state update.
     * Update all of the objects created during running the game
     * and allows the game to exit when the escape key is pressed.
     *
     * @param input Input to input the keyboard and mouse signal
     */
    @Override
    protected void update(Input input) {
        updateAll();
    }

    /**
     * Base method to run the Game
     *
     * @param args String[] in format: "long" "long" "String"
     *             which matches the "tick rate", the "max ticks", and the "world file"
     */
    public static void main(String[] args) {
        if(args.length > 3){
            System.exit(-1);
        }

        try {
            tickRate = Integer.parseInt(args[0]);
            maxTick = Integer.parseInt(args[1]);
            worldFile = args[2];

        } catch (NumberFormatException e){
            System.out.println("Number format is invalid, Please try another input");
        }
        new ShadowLife().run();
    }

    // Local method updateAll: Handle all the updating problems and update to th Window
    private void updateAll(){
        if(System.currentTimeMillis() - moveStd >= tickRate) {
            currentTick++;
            gathererUpdate();
            thiefUpdate();
            copy();
            moveStd = System.currentTimeMillis();
        }

        draw();

        if(endOfGame()){
            System.out.println(currentTick + " ticks");
            for (Object object: characters[STATIONARY]) {
                if(object instanceof Stockpile){
                    Stockpile stockpile = (Stockpile) object;
                    System.out.println(stockpile);
                }
            }
            System.exit(0);
        }
    }

    private void gathererUpdate(){
        for (Object sprite : characters[GATHERER]) {
            Gatherer gatherer = (Gatherer) sprite;
            gatherer.move();
            for(Object object : characters[STATIONARY]) {
                if(object instanceof Pool){
                    Pool pool = (Pool) object;
                    if(gatherer.changeDirection(pool)){
                        Creature.destroyList.add(gatherer);
                    }
                }else{
                    gatherer.changeDirection(object);
                }
            }
        }
    }

    private void thiefUpdate(){
        for (Object sprite: characters[THIEF]){
            Thief thief = (Thief) sprite;
            thief.move();
            for(Object object : characters[STATIONARY]) {
                if(object instanceof Pool){
                    Pool pool = (Pool) object;
                    if(thief.changeDirection(pool)){
                        Creature.destroyList.add(thief);
                    }
                }else{
                    thief.changeDirection(object);
                }
            }
            for (Object object : characters[GATHERER]) {
                Gatherer gatherer = (Gatherer) object;
                thief.changeDirection(gatherer);
            }
        }
    }

    private void copy(){
        for(Object object : Creature.copyList){
            if(object == null)
                break;
            else {
                Creature creature = (Creature) object;
                creature.move();
                if(object instanceof Gatherer)
                    characters[GATHERER].add(creature);
                else
                    characters[THIEF].add(object);
            }

        }
        Creature.copyList.clear();

        for(Object object : Creature.destroyList){
            if(object == null)
                break;
            if(object instanceof Gatherer)
                characters[GATHERER].remove(object);
            else
                characters[THIEF].remove(object);
        }
        Creature.destroyList.clear();
    }

    private void draw(){
        for (ArrayList sprites: characters) {
            if(!(sprites == null)) {
                ArrayList<Sprite> objects = (ArrayList<Sprite>) sprites;
                for (Sprite object : objects) {
                    object.draw();
                }
            }
        }
    }

    private boolean endOfGame(){
        if(currentTick > maxTick){
            System.out.println("Timed out");
            System.exit(-1);
        }
        for (Object object: characters[GATHERER]) {
            Gatherer gatherer = (Gatherer) object;
            if(gatherer.isActive()){
                return false;
            }
        }
        for (Object object: characters[THIEF]) {
            Thief thief = (Thief) object;
            if(thief.isActive()){
                return false;
            }
        }
        return true;
    }
}
