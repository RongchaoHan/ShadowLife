package util;

// Import packages: local
import Sprite.Background;
import Sprite.Creatures.*;
import Sprite.Stationary.*;

// Import packages: library
import bagel.util.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

/**
 *  World class
 *  Describe the background of the Game
 *  Read the Initial state of the Game from the Setting CSV file
 *  Create Objects for the Game
 *  Created by Rongchao Han with ID: 1002758
 */
public class World{

    // Constant
    private static final int BACKGROUND = 0;
    private static final int STATIONARY = 1;
    private static final int GATHERER = 2;
    private static final int THIEF = 3;

    // Attributes
    private ArrayList[] characters = new ArrayList[4];
    private String worldFile;

    /** Constructor for World class
     *
     *  @param worldFile The file name of the input world file in csv format
     */
    public World(String worldFile){
        this.worldFile = worldFile;
        for (int i = 0; i < characters.length; i++) {
            characters[i] = new ArrayList();
        }
        characters[BACKGROUND].add(new Background());
        readFile();
    }

    // Getters
    public ArrayList[] getCharacters() {
        return characters;
    }

    // Read the information of world file
    private void readFile(){
        try{
            Scanner scanner = new Scanner(new FileReader(this.worldFile));
            int lineNumber = 0;

            while(scanner.hasNextLine()){

                String[] split = scanner.nextLine().split(",");
                if(split.length != 3){
                    System.out.println("error: in file "+ worldFile + " at line " + lineNumber);
                }
                lineNumber++;

                Point position = new Point(Double.parseDouble(split[1]),
                                           Double.parseDouble(split[2]));
                switch (split[0]) {
                    case "Tree":
                        characters[STATIONARY].add(new Tree(position));
                        break;
                    case "GoldenTree":
                        characters[STATIONARY].add(new GoldenTree(position));
                        break;
                    case "Stockpile":
                        characters[STATIONARY].add(new Stockpile(position));
                        break;
                    case "Gatherer":
                        characters[GATHERER].add(new Gatherer(position));
                        break;
                    case "Thief":
                        characters[THIEF].add(new Thief(position));
                        break;
                    case "Fence":
                        characters[STATIONARY].add(new Fence(position));
                        break;
                    case "SignDown":
                        characters[STATIONARY].add(new SignDown(position));
                        break;
                    case "SignUp":
                        characters[STATIONARY].add(new SignUp(position));
                        break;
                    case "SignLeft":
                        characters[STATIONARY].add(new SignLeft(position));
                        break;
                    case "SignRight":
                        characters[STATIONARY].add(new SignRight(position));
                        break;
                    case "Pool":
                        characters[STATIONARY].add(new Pool(position));
                        break;
                    case "Pad":
                        characters[STATIONARY].add(new Pad(position));
                        break;
                    case "Hoard":
                        characters[STATIONARY].add(new Hoard(position));
                        break;
                }
            }

        } catch(IOException | NumberFormatException e){
            System.out.println("error: file "+ worldFile + " not found");
            System.exit(-1);
        }
    }
}
