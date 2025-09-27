package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Fan extends GamePiece{
	public Fan(int location){
		super('F',"Fan",location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(this.getLocation() -1 == playerLocation || this.getLocation() -2 == playerLocation) {
			return InteractionResult.HIT;
		}else return InteractionResult.NONE;
	}

}
