package levelPieces;
import gameEngine.Drawable;

public class Chair implements Drawable{
	protected char symbol = 'c';
	@Override
	public void draw() {
		System.out.print(symbol);
	}
}
