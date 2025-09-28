/**
 * Roomba piece in Kerplop. Moves in a linear manner
 * 
 * @author Ryan Koch
 * @author Yamato Matsumura
 * 
 */

package levelPieces;

import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Roomba extends GamePiece implements Moveable{
	
	int direction;
	private Drawable originalPiece = null; // save what the Roomba landed on when it moved 
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		// Handles edge case when roomba starts at 20 or 0 and needs to turn around
		if (this.getLocation() == 20 && this.direction == 1) {
			this.direction = this.direction * -1;
		}
		else if (this.getLocation() == 0 && this.direction == -1) {
			this.direction = this.direction * -1;
		}

		
		// Don't add back if Dog since dog will move away anyway
		if(!(originalPiece instanceof Dog)) {
			gameBoard[this.getLocation()] = this.originalPiece; // restore previous square to its original piece
		}

		int newLoc = this.getLocation() + this.direction; // Find next LOCATION
		
		originalPiece = gameBoard[newLoc]; // update what piece Roomba landed on
		gameBoard[newLoc] = this; // move Roomba on top of original piece
		this.setLocation(newLoc);
		
		// Turn roomba around once it lands on the edge of the board
		if (newLoc == 20 || newLoc == 0) {
			this.direction = this.direction * -1;
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
