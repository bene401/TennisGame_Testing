import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Ignore
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		//game.player1Scored();
		//game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();	
		//game.player1Scored();
	}
	
	@Test
	public void testTennisGame_Player1HasAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player1 has advantage", score);
	}
	
	@Test
	public void testTennisGame_Player2HasAdvantage() throws TennisGameException {
		TennisGame game = new TennisGame();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player2Scored();
		
		String score2 = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "player2 has advantage", score2);
	}
	
	@Test 
	public void testTennisGame_Player1Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();		
		
		game.player1Scored();
		game.player1Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals( "player1 wins", score);
		
		
	}
	@Test 
	public void testTennisGame_Player2Wins() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		String score = game.getScore() ;
		// Assert
		assertEquals( "player2 wins", score);	
		
	}
	
	@Test 
	public void testTennisGame_Player1has0Points_Player2hasNotFinished() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		
		game.player2Scored();		
		game.player2Scored();
		game.player2Scored();
		
		
		String score = game.getScore() ;
		// Assert
		assertEquals( "love - 40", score);	
		
	}
	

	@Test 
	public void testTennisGame_Player2has0Points_Player1hasNotFinished() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		
		game.player1Scored();		
		game.player1Scored();
		game.player1Scored();
		
		
		String score = game.getScore() ;
		// Assert
		assertEquals( "40 - love", score);	
		
	}
	
	@Test 
	public void testTennisGame_Player1has15Points_Player2has30Points() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		
		game.player1Scored();
		
		game.player2Scored();		
		game.player2Scored();
		
		
		String score = game.getScore() ;
		// Assert
		assertEquals( "15 - 30", score);	
		
	}
	
	public void testTennisGame_both30() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();		
		game.player2Scored();
		
		
		String score = game.getScore() ;
		// Assert
		assertEquals( "30 - 30", score);	
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
