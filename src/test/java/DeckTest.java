import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class DeckTest {
	private Deck deck;
	
	@Test
	void Constructor_Test() {
		
		try {
			
			deck = new Deck();
			ArrayList<Card> temp = deck.getDeck();
			assertEquals(52,temp.size(),"Wrong Size");
			temp = deck.newDeck();
			assertEquals(52,temp.size(),"Wrong Size");	
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
	}

//	try {
//		
//    } catch (IllegalArgumentException ex) {
//    	assertFalse(ex.getMessage().contains("Invalid Random"));
//    	assertFalse(ex.getMessage().contains("Invalid Suit"));
//        assertFalse(ex.getMessage().contains("Invalid Value"));
//    }
	
	@Test
	void newDeck_Test_1() {
			
        try {
        	deck = new Deck();
        	ArrayList<Card> temp = deck.newDeck();
        	temp = deck.newDeck();
        	temp = deck.newDeck();
        	temp = deck.newDeck();
        	temp = deck.newDeck();
        	temp = deck.newDeck();
        	temp = deck.newDeck();
        	temp = deck.newDeck();
        
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
	
	}
	
	@Test
	void makeDeck_Test_1() {
			
        try {
        	deck = new Deck();
        	ArrayList<Card> temp = deck.getDeck();
        	deck = new Deck();
        	temp = deck.getDeck();
        	deck = new Deck();
        	temp = deck.getDeck();
        	deck = new Deck();
        	temp = deck.getDeck();
        	deck = new Deck();
        	temp = deck.getDeck();
        
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
	
	}
	
	@Test
	void makeDeck_Test_2() {
			
        try {
        	deck = new Deck();
        	ArrayList<Card> temp = deck.getDeck();
        	temp.get(0).setSuit('C');
        	temp.get(0).setValue(3);
        
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
	
	}
	
	@Test
	void makeDeck_Test_3() {
			
        try {
        	deck = new Deck();
        	ArrayList<Card> temp = deck.getDeck();
        	temp.get(0).setSuit('G');
        	temp.get(0).setValue(3);
        
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertTrue(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
	
	}
	
	@Test
	void makeDeck_Test_4() {
			
        try {
        	deck = new Deck();
        	ArrayList<Card> temp = deck.getDeck();
        	temp.get(0).setSuit('C');
        	temp.get(0).setValue(1);
        
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertTrue(ex.getMessage().contains("Invalid Value"));
        }
	
	}
	
	@Test
	void makeDeck_Test_5() {
			
        try {
        	deck = new Deck();
        	ArrayList<Card> temp = deck.getDeck();
        	temp.get(0).setSuit('C');
        	temp.get(0).setValue(15);
        
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertTrue(ex.getMessage().contains("Invalid Value"));
        }
	
	}
	
	
	@Test
	void getSizeOfDeck_Test_1() {
			
        try {
        	deck = new Deck();
    		assertEquals(52,deck.getSizeOfDeck(),"Wrong Size");
    		ArrayList<Card> temp = deck.getDeck();
    		assertEquals(52,temp.size(),"Wrong Size");
    		
    		temp = deck.newDeck();
    		assertEquals(52,deck.getSizeOfDeck(),"Wrong Size");
    		assertEquals(52,temp.size(),"Wrong Size");
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
		
		
		
	}
	
	@Test
	void removeDeckItem_Test_1() {
		
		try {
			deck = new Deck();
			ArrayList<Card> temp = deck.getDeck();
			Card tem_card = temp.get(6);
			assertEquals(tem_card.getSuit(),temp.get(6).getSuit(),"Wrong suit");
			assertEquals(tem_card.getValue(),temp.get(6).getValue(),"Wrong value");
			
			deck.removeDeckItem(5);
			assertEquals(tem_card.getSuit(),temp.get(5).getSuit(),"Wrong suit");
			assertEquals(tem_card.getValue(),temp.get(5).getValue(),"Wrong value");
			
	    } catch (IllegalArgumentException ex) {
	    	assertFalse(ex.getMessage().contains("Invalid Random"));
	    	assertFalse(ex.getMessage().contains("Invalid Suit"));
	        assertFalse(ex.getMessage().contains("Invalid Value"));
	    }
	}
	
	@Test
	void removeDeckItem_Test_2() {
		
		try {
			deck = new Deck();
			ArrayList<Card> temp = deck.getDeck();
			Card tem_card = temp.get(8);
			assertEquals(tem_card.getSuit(),temp.get(8).getSuit(),"Wrong suit");
			assertEquals(tem_card.getValue(),temp.get(8).getValue(),"Wrong value");
			
			deck.removeDeckItem(5);
			assertEquals(tem_card.getSuit(),temp.get(7).getSuit(),"Wrong suit");
			assertEquals(tem_card.getValue(),temp.get(7).getValue(),"Wrong value");
			
	    } catch (IllegalArgumentException ex) {
	    	assertFalse(ex.getMessage().contains("Invalid Random"));
	    	assertFalse(ex.getMessage().contains("Invalid Suit"));
	        assertFalse(ex.getMessage().contains("Invalid Value"));
	    }
	}
	
	
	
	
	
	
	
	
	
}