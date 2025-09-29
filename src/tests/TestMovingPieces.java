package tests;

import static org.junit.jupiter.api.Assertions.*;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Roomba;
import levelPieces.Dog;

import org.junit.jupiter.api.Test;

public class TestMovingPieces {
	/*
	* Test that the roomba can turn around at the edge and can move left
	*/
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
	/*
	* Test that roomba can more right normally
	*/
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
	/*
	* Test that dog moves a random number squares (1-9) and does not appear anywhere else
	*/
	@Test
	public void DogRandomMotion() {
		int locCount0 = 0;
		int locCount1 = 0;
		int locCount2 = 0;
		int locCount3 = 0;
		int locCount4 = 0;
		int locCount5 = 0;
		int locCount6 = 0;
		int locCount7 = 0;
		int locCount8 = 0;
		int locCount9 = 0;
		int locCount10 = 0;
		int locCount11 = 0;
		int locCount12 = 0;
		int locCount13 = 0;
		int locCount14 = 0;
		int locCount15 = 0;
		int locCount16 = 0;
		int locCount17 = 0;
		int locCount18 = 0;
		int locCount19 = 0;
		int locCount20 = 0;
		
		for(int i=0;i<200;i++) {
			Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			Dog dog = new Dog(0);
			gameBoard[0] = dog;
			dog.move(gameBoard,20);
			// Get the dog's final location and increment the corresponding counter
	        switch (dog.getLocation()) {
	            case 0:
	            	locCount0++;
	                break;
	            case 1:
	                locCount1++;
	                break;
	            case 2:
	                locCount2++;
	                break;
	            case 3:
	                locCount3++;
	                break;
	            case 4:
	                locCount4++;
	                break;
	            case 5:
	                locCount5++;
	                break;
	            case 6:
	                locCount6++;
	                break;
	            case 7:
	                locCount7++;
	                break;
	            case 8:
	                locCount8++;
	                break;
	            case 9:
	                locCount9++;
	                break;
	            case 10:
	                locCount10++;
	                break;
	            case 11:
	                locCount11++;
	                break;
	            case 12:
	                locCount12++;
	                break;
	            case 13:
	                locCount13++;
	                break;
	            case 14:
	                locCount14++;
	                break;
	            case 15:
	                locCount15++;
	                break;
	            case 16:
	                locCount16++;
	                break;
	            case 17:
	                locCount17++;
	                break;
	            case 18:
	                locCount18++;
	                break;
	            case 19:
	                locCount19++;
	                break;
	            case 20:
	            	locCount20++;
	                break;
	        	}
		}
		// Assertions for locations 1 through 9 (Expected landing spots)
        // Dog starts at 0 and jumps 1-9 to the right (direction=1).
        // Since the jump distance is random (1-9), the dog should land in all these spots at least once.
        assert(locCount1 > 1);
        assert(locCount2 > 1);
        assert(locCount3 > 1);
        assert(locCount4 > 1);
        assert(locCount5 > 1);
        assert(locCount6 > 1);
        assert(locCount7 > 1);
        assert(locCount8 > 1);
        assert(locCount9 > 1);

        // Assertions for locations 0 and 10-20 (Expected to be 0 or near 0)
        // Since the dog starts at 0 and moves right (direction=1), it should *never* land back at 0
        // and should not land beyond 9 in a single jump.
        
        // Loc 0: Should be 0 since the dog always moves 1-9 spaces on the first turn.
        assertEquals(0, locCount0);
        
        // Locs 10-20: Should be 0 since the max jump distance is 9 (0 + 9 = 9).
        assertEquals(0,locCount10);
        assertEquals(0,locCount11);
        assertEquals(0, locCount12);
        assertEquals(0, locCount13);
        assertEquals(0, locCount14);
        assertEquals(0, locCount15);
        assertEquals(0, locCount16);
        assertEquals(0, locCount17);
        assertEquals(0, locCount18);
        assertEquals(0, locCount19);
        assertEquals(0, locCount20);
    }
}



