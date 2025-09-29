package tests;

import static org.junit.jupiter.api.Assertions.*;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Roomba;


import org.junit.jupiter.api.Test;

public class TestMovingPieces {
	
	@Test
	public void RoombaMoveLeft(){
		// Make sure roomba moves left and turns around at the end of the array
			Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			Roomba roomba = new Roomba(20);
			gameBoard[20] = roomba;
			
			roomba.move(gameBoard, 18);
			
			assertEquals(19, roomba.getLocation());
			assertEquals(gameBoard[19], roomba);
			// These loops ensure the roomba is only on the desired square
				for (int i=0; i<18; i++)
					assertNotEquals(gameBoard[i], roomba);
				
				assertNotEquals(gameBoard[20], roomba);
		}
	
	@Test
	public void RoombaMoveRight(){
		// Make sure roomba moves right
			Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			Roomba roomba = new Roomba(0);
			gameBoard[0] = roomba;
			
			roomba.move(gameBoard, 18);
			
			assertEquals(1, roomba.getLocation());
			assertEquals(gameBoard[1], roomba);
			// These loops ensure the roomba is only on the desired square
				for (int i=2; i<21; i++)
					assertNotEquals(gameBoard[i], roomba);
				
				assertNotEquals(gameBoard[0], roomba);
		}
	
	}


