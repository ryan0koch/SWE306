/**
 * Dog piece in Kerplop. Moves in a random matter
 * 
 * @author Ryan Koch
 * @author Yamato Matsumura
 * 
 */

package levelPieces;

import gameEngine.Moveable;
import java.util.Random;
import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Dog extends GamePiece implements Moveable{
	Random random = new Random();
	int direction;
	int speed;
	private Drawable originalPiece = null; // save what the Dog landed on when it moved
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		// Don't add back Roomba since roomba will move away anyway
		if (!(this.originalPiece instanceof Roomba)) {
			gameBoard[this.getLocation()] = this.originalPiece; // remove piece from old square
		}
		
		speed = random.nextInt(9) + 1; // move a random number of tiles between 0-9
		int newLoc = this.getLocation() + (speed* this.direction); // Find new LOCATION
		
		if(MoveHelper.onBoard(newLoc)){ // Check if moving off the board
			originalPiece = gameBoard[newLoc]; // update what piece dog landed on
			gameBoard[newLoc] = this; // move dog on top of original piece
			this.setLocation(newLoc);
		}else {
			this.direction = this.direction * -1;
			newLoc = this.getLocation() + (speed* this.direction); // switch direction
			originalPiece = gameBoard[newLoc]; // update what piece dog landed on
			gameBoard[newLoc] = this;
			this.setLocation(newLoc);
		}
	}
	
	public Dog(int location){
		super('D',"Dog",location);
		this.direction = 1; // default to moving right
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(this.getLocation()  == playerLocation) {
			return InteractionResult.ADVANCE;
		}else return InteractionResult.NONE;
	}
	
}
