package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Heater extends GamePiece{
	
	public Heater(int location){
		super('H',"Heater",location);
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if(this.getLocation() + 1 == playerLocation || this.getLocation() - 1 == playerLocation) {
			return InteractionResult.HIT;
		}else return InteractionResult.NONE;
	}
}
