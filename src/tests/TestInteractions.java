package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import gameEngine.*;
import levelPieces.*;

public class TestInteractions {
	
	/*
	* Test that CoffeeTable kills player (interaction) only when player is on same location
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

	/*
	* Test that dog advances player (interaction) only when player is on same location
	*/
	@Test
	public void testDog() {
		
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Dog dog = new Dog(10);
		gameBoard[10] = dog;

		// Make sure interaction result is to advance
		assertEquals(InteractionResult.ADVANCE, dog.interact(gameBoard, 10));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, dog.interact(gameBoard, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, dog.interact(gameBoard, i));
	}

	/*
	* Test that roomba hits player moving right (interaction) only when player is on same location
	*/
	@Test
	public void testRoombaHitRight() {
		
		// Make sure roomba hits player moving right
		Drawable [] gameBoard1 = new Drawable[GameEngine.BOARD_SIZE];
		Roomba roomba1 = new Roomba(9); // Roomba defaults to moving right so start it on the left of the player
		gameBoard1[9] = roomba1;

		// Make sure interaction result is hit
		assertEquals(InteractionResult.HIT, roomba1.interact(gameBoard1, 10));
		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<10; i++)
			assertEquals(InteractionResult.NONE, roomba1.interact(gameBoard1, i));
		for (int i=11; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, roomba1.interact(gameBoard1, i));
	}
		
	
	/*
	* Test that roomba hits player moving left (interaction) only when player is on same location
	*/
	@Test
	public void testRoombaHitLeft() {
		
		// Make sure roomba hits player moving left
		Drawable [] gameBoard2 = new Drawable[GameEngine.BOARD_SIZE];
		Roomba roomba2 = new Roomba(20);
		gameBoard2[20] = roomba2;
		
		roomba2.move(gameBoard2, 18);
		
		assertEquals(InteractionResult.HIT, roomba2.interact(gameBoard2, 18));
		
		// These loops ensure no interaction if roomba is not going to move onto the square the player is on
		for (int i=0; i<18; i++)
			assertEquals(InteractionResult.NONE, roomba2.interact(gameBoard2, i));
		for (int i=19; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, roomba2.interact(gameBoard2, i));
	}

	/*
	* Test that fan hits player (interaction) only when player is either one or two tiles to the left
	*/
	@Test
	public void testFan() {
		
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Fan fan = new Fan(10);
		gameBoard[10] = fan;

		// Make sure interaction result is hit
		assertEquals(InteractionResult.HIT, fan.interact(gameBoard, 9));
		assertEquals(InteractionResult.HIT, fan.interact(gameBoard, 8));

		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<8; i++)
			assertEquals(InteractionResult.NONE, fan.interact(gameBoard, i));
		for (int i=10; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, fan.interact(gameBoard, i));
	}
	
	/*
	* Test that heater hits player (interaction) only when player is either adjacent square
	*/
	@Test
	public void testHeater() {
		
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Heater heater = new Heater(10);
		gameBoard[10] = heater;

		// Make sure interaction result is hit
		assertEquals(InteractionResult.HIT, heater.interact(gameBoard, 9));
		assertEquals(InteractionResult.HIT, heater.interact(gameBoard, 11));

		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<9; i++)
			assertEquals(InteractionResult.NONE, heater.interact(gameBoard, i));

		assertEquals(InteractionResult.NONE, heater.interact(gameBoard, 10));	  // No interaction if on same square

		for (int i=12; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, heater.interact(gameBoard, i));
	}

	/*
	* Test that tv gives player points (interaction) only when player is 4 squares away on either side
	*/
	@Test
	public void testTV() {
		
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		TV tv = new TV(10);
		gameBoard[10] = tv;

		// Make sure interaction result is get point
		assertEquals(InteractionResult.GET_POINT, tv.interact(gameBoard, 6));
		assertEquals(InteractionResult.GET_POINT, tv.interact(gameBoard, 14));

		
		// These loops ensure no interaction if not on same space
		for (int i=0; i<6; i++)
			assertEquals(InteractionResult.NONE, tv.interact(gameBoard, i));
		for (int i=7; i < 14; i++)
			assertEquals(InteractionResult.NONE, tv.interact(gameBoard, i));
		for (int i=15; i<GameEngine.BOARD_SIZE; i++)	
			assertEquals(InteractionResult.NONE, tv.interact(gameBoard, i));
	}
	
	
}
