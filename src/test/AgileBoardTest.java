package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import agileboard.Board;
import agileboard.Card;
import agileboard.Iteration;
import agileboard.StatusClass;
import errorutility.CardMoveNotAllowed;

public class AgileBoardTest {
	
	private Iteration createTestSubject(){
		Board board = new Board(StatusClass.initializeColumns());
		Iteration iteration = board.getCurrentIteration();
		
		return iteration;
	}
	
	@Test
	public void testAddCard() {
		Iteration iteration = createTestSubject();
		Card c1 = new Card("C1", "This is C1 card.", 5);
		iteration.addCard(c1);
		
		assertEquals("Add Card will add card into Iteration.",true,iteration.getCards().size() > 0);
		assertEquals("Add Card will add card in Starting column", StatusClass.START, iteration.getCards().get(0).getCurrentColumnId());
	}
	
	@Test
	public void testMoveCard() {
		Iteration iteration = createTestSubject();
		Card c1 = new Card("C1", "This is C1 card.", 5);
		iteration.addCard(c1);
		
		iteration.moveCard(c1, "done");
		
		assertEquals("Move Card will move card to new Column.", StatusClass.DONE, iteration.getCards().get(0).getCurrentColumnId());
	}
	
	@Test
	public void testUndoLastMove() {
		Iteration iteration = createTestSubject();
		Card c1 = new Card("C1", "This is C1 card.", 5);
		iteration.addCard(c1);
		
		assertEquals("Intial State.", StatusClass.START, iteration.getCards().get(0).getCurrentColumnId());
		
		iteration.moveCard(c1, "done");
		assertEquals("Moved State.", StatusClass.DONE, iteration.getCards().get(0).getCurrentColumnId());
		
		iteration.undoLastMove();
		
		assertEquals("Undo Last Move will move card in intitial state", StatusClass.START, iteration.getCards().get(0).getCurrentColumnId());
	}
	
	@Test
	public void testVelocity() {
		Iteration iteration = createTestSubject();
		Card c1 = new Card("C1", "This is C1 card.", 5);
		iteration.addCard(c1);
		
		assertEquals("Intial State.", StatusClass.START, iteration.getCards().get(0).getCurrentColumnId());
		
		iteration.moveCard(c1, "done");
		assertEquals("Moved State.", StatusClass.DONE, iteration.getCards().get(0).getCurrentColumnId());
		
		
		assertEquals("Velocity should be 5.", 5 , iteration.velocity());
		
		
		Card c2 = new Card("C2", "This is C2 card.", 20);
		iteration.addCard(c2);
		iteration.moveCard(c2, StatusClass.DONE);
		
		assertEquals("Velocity should be 25.", 25 , iteration.velocity());
	}
	
	@Test
	public void testUpdateColumnLimit() {
		Iteration iteration = createTestSubject();
		Card c1 = new Card("C1", "This is C1 card.", 5);
		iteration.addCard(c1);
		
		assertEquals("Intial State.", StatusClass.START, iteration.getCards().get(0).getCurrentColumnId());
		
		iteration.moveCard(c1, StatusClass.inProgress);
		assertEquals("Moved to InProgress Card1.", StatusClass.inProgress, iteration.getCards().get(0).getCurrentColumnId());
		
		
		Card c2 = new Card("C2", "This is C2 card.", 20);
		iteration.addCard(c2);
		iteration.moveCard(c2, StatusClass.inProgress);
		
		assertEquals("Moved to InProgress Card2.", StatusClass.inProgress, iteration.getCards().get(1).getCurrentColumnId());
		
		assertEquals("Velocity should be 0.", 0 , iteration.velocity());
		
		iteration.undoLastMove();
		
		assertEquals("Undo Move Card2. Going back to starting.", StatusClass.START, iteration.getCards().get(1).getCurrentColumnId());
		
		iteration.updateColumnLimit(StatusClass.inProgress, 15);
		try{
			iteration.moveCard(c2, StatusClass.inProgress);
		} catch(CardMoveNotAllowed ex){
			assertEquals("Exception should error with message.", "Card move not allowed. Cannot move. Defined Limit : 15 , Exceeds current estimate points allocation : 25", ex.getMessage());
		}
		
		assertEquals("Moved State should not happen. Card2 should remain in Starting column", StatusClass.START, iteration.getCards().get(1).getCurrentColumnId());
	}
	
	
	

}
