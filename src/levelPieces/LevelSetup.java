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
		this.board[2] = new Chair();
	}
	
	private void setupLevel2() {
		this.board[7] = new Chair();
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
