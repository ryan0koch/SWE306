package levelPieces;
import gameEngine.GameEngine;
public class MoveHelper {
	public static boolean onBoard(int loc) {
		if(loc> GameEngine.BOARD_SIZE -1 || loc < 0) {
			return false;
		}else return true;
	}
}
