package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class TV extends GamePiece{
	
	public TV (int location) {
		super('T', "TV", location);
	}
	
	@Override
	public InteractionResult interact(Drawable[] gameboard, int playerLocation) {
		if(this.getLocation() + 4 == playerLocation || this.getLocation() - 4 == playerLocation) {
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}
	}
}
