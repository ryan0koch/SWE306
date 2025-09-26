package levelPieces;
import gameEngine.InteractionResult;
import gameEngine.Drawable;

public class CoffeeTable extends GamePiece {

		public CoffeeTable(int location){
			super('U',"CoffeeTable",location);
		}
		
		@Override
		public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
			if(this.getLocation() == playerLocation) {
				return InteractionResult.KILL;
			}else return InteractionResult.NONE;
		}
}
