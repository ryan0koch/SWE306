package levelPieces;

import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Roomba extends GamePiece implements Moveable{
	
	int direction;
	private Drawable originalPiece = null; // save what the Roomba landed on when it moved 
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		gameBoard[this.getLocation()] = this.originalPiece; // restore previous square to its original piece
		int newLoc = this.getLocation() + this.direction; // Find next LOCATION
		
		if(MoveHelper.onBoard(newLoc)){ // Check if moving off the board
			originalPiece = gameBoard[newLoc]; // update what piece Roomba landed on
			gameBoard[newLoc] = this; // move Roomba on top of original piece
			this.setLocation(newLoc);
		}else {
			this.direction = this.direction * -1;
			newLoc = this.getLocation() + this.direction; // switch direction
			originalPiece = gameBoard[newLoc]; // update what piece Roomba landed on
			gameBoard[newLoc] = this;
			this.setLocation(newLoc);
		}
	}
	
	public Roomba(int location){
		super('R',"Roomba",location);
		this.direction = 1; // default to moving right
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(this.getLocation() + this.direction == playerLocation) {
			return InteractionResult.HIT;
		}else return InteractionResult.NONE;
	}
	
}
