package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import gameEngine.*;
import levelPieces.*;

public class TestInteractions {
	
	/*
	* Tests that the coffee table kills the player on the same square, and has no interaction otherwise
	*/
	@Test
	public void testCoffeeTable() {
		
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		CoffeeTable coffeeTable = new CoffeeTable(10);
		gameBoard[10] = coffeeTable;

		// Make sure interaction result is kill
		assertEquals(InteractionResult.KILL, coffeeTable.interact(gameBoard, 10));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, coffeeTable.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, coffeeTable.interact(gameBoard, i));
	}
}
