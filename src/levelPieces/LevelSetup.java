/**
 * hard codes level 1 and 2 for game
 * 
 * @author Ryan Koch
 * @author Yamato Matsumura
 * 
 */

package levelPieces;

import java.util.ArrayList;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Player;


public class LevelSetup {
	
	private Drawable[] board;
	private ArrayList<Moveable> moveableArr;
	private ArrayList<GamePiece> interactableArr;
	private int playerStartLoc;
	
	
	public LevelSetup() {
		// Initialize the board array with size set in GameEngine
		this.board = new Drawable[GameEngine.BOARD_SIZE]; 
		
		// Initialize the ArrayLists to hold the pieces
		this.moveableArr = new ArrayList<Moveable>();
		this.interactableArr = new ArrayList<GamePiece>();
		
		// Set a default player start loc to first space
		this.playerStartLoc = 0; 
	}
	
	public void createLevel(int levelNumber) {
		switch (levelNumber) {
	    case 1:
	        // Call a private method to handle Level 1 setup
	        setupLevel1();
	        break;
	    case 2:
	        // Call a private method to handle Level 2 setup
	        setupLevel2();
	        break;
	    default:
	    	break;
		}
	}
	
	private void setupLevel1() {
		CoffeeTable coffeeTable = new CoffeeTable(3);
		this.board[3] = coffeeTable;
		interactableArr.add(coffeeTable);
		
		Heater heater = new Heater(8);
		this.board[8] = heater;
		interactableArr.add(heater);
		
		TV tv = new TV(13);
		this.board[13] = tv;
		interactableArr.add(tv);
		
		Chair chair = new Chair();
		this.board[16] = chair;
		
		Fan fan = new Fan(18);
		this.board[18] = fan;
		interactableArr.add(fan);
		
		Dog dog = new Dog(5);
		this.board[5] = dog;
		interactableArr.add(dog);
		moveableArr.add(dog);
		
		Roomba roomba = new Roomba(20);
		this.board[20] = roomba;
		interactableArr.add(roomba);
		moveableArr.add(roomba);
	}
	
	private void setupLevel2() {
		// Reset interaction, movement, and board arrays
		this.interactableArr.clear();
		this.moveableArr.clear();
		this.board = new Drawable[GameEngine.BOARD_SIZE]; 

		
		CoffeeTable coffeeTable = new CoffeeTable(17);
		this.board[17] = coffeeTable;
		interactableArr.add(coffeeTable);
		
		Heater heater = new Heater(3);
		this.board[3] = heater;
		interactableArr.add(heater);
		
		TV tv = new TV(12);
		this.board[12] = tv;
		interactableArr.add(tv);
		
		Chair chair = new Chair();
		this.board[7] = chair;
		
		Fan fan = new Fan(18);
		this.board[18] = fan;
		interactableArr.add(fan);
		
		Dog dog = new Dog(20);
		this.board[20] = dog;
		interactableArr.add(dog);
		moveableArr.add(dog);
		
		Roomba roomba = new Roomba(6);
		this.board[6] = roomba;
		interactableArr.add(roomba);
		moveableArr.add(roomba);
	}
	
	public Drawable[] getBoard(){
		return this.board;
	}
	public ArrayList<Moveable> getMovingPieces(){
		return this.moveableArr;
	}
	public ArrayList<GamePiece> getInteractingPieces(){
		return this.interactableArr;
	}
	public int getPlayerStartLoc(){
		return this.playerStartLoc;
	}
}
