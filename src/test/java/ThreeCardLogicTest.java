import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ThreeCardLogicTest {

	private ThreeCardLogic logic;
	private Card card;
	
	
	@Test
	void getMinValue_test_1() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',7);
			Hand.add(card);
			card = new Card('D',6);
			Hand.add(card);
			card = new Card('S',5);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMinValue(Hand);
			assertEquals(5,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getMinValue_test_2() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',6);
			Hand.add(card);
			card = new Card('S',5);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMinValue(Hand);
			assertEquals(4,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getMinValue_test_3() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',3);
			Hand.add(card);
			card = new Card('S',5);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMinValue(Hand);
			assertEquals(3,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getMinValue_test_4() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',3);
			Hand.add(card);
			card = new Card('S',3);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMinValue(Hand);
			assertEquals(3,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getMaxValue_test_1() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',5);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMaxValue(Hand);
			assertEquals(6,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getMaxValue_test_2() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',7);
			Hand.add(card);
			card = new Card('D',5);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMaxValue(Hand);
			assertEquals(7,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getMaxValue_test_3() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',7);
			Hand.add(card);
			card = new Card('D',8);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMaxValue(Hand);
			assertEquals(8,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getMaxValue_test_4() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',7);
			Hand.add(card);
			card = new Card('D',7);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int[] temp = ThreeCardLogic.getMaxValue(Hand);
			assertEquals(7,temp[0],"Wrong value");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	
	
	
	@Test
	void checkForStraight_test_1() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',5);
			Hand.add(card);
			card = new Card('D',6);
			Hand.add(card);
			card = new Card('S',7);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.checkForStraight(Hand.get(0).getValue(), Hand.get(1).getValue(), Hand.get(2).getValue(), Hand);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void checkForStraight_test_2() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',6);
			Hand.add(card);
			card = new Card('S',7);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.checkForStraight(Hand.get(0).getValue(), Hand.get(1).getValue(), Hand.get(2).getValue(), Hand);
		    assertEquals(-1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void checkForStraight_test_3() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',5);
			Hand.add(card);
			card = new Card('S',7);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.checkForStraight(Hand.get(0).getValue(), Hand.get(1).getValue(), Hand.get(2).getValue(), Hand);
		    assertEquals(-1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void checkForStraight_test_4() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',6);
			Hand.add(card);
			card = new Card('S',5);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.checkForStraight(Hand.get(0).getValue(), Hand.get(1).getValue(), Hand.get(2).getValue(), Hand);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void checkForStraight_test_5() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',7);
			Hand.add(card);
			card = new Card('D',6);
			Hand.add(card);
			card = new Card('S',5);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.checkForStraight(Hand.get(0).getValue(), Hand.get(1).getValue(), Hand.get(2).getValue(), Hand);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_1() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('C',9);
			Hand.add(card);
			card = new Card('C',8);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_2() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',9);
			Hand.add(card);
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('C',8);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_3() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(2,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_4() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(2,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_5() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',9);
			Hand.add(card);
			card = new Card('D',7);
			Hand.add(card);
			card = new Card('S',8);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(3,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_6() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',6);
			Hand.add(card);
			card = new Card('C',8);
			Hand.add(card);
			card = new Card('C',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(4,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_7() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',6);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(5,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_8() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',6);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(5,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalHand_test_0() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalHand(Hand);
		    assertEquals(0,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	
	@Test
	void evalPPWinnings_test_1() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('C',9);
			Hand.add(card);
			card = new Card('C',8);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(40,temp,"Wrong number");
		    temp = ThreeCardLogic.evalPPWinnings(Hand, 2);
		    assertEquals(80,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_2() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',9);
			Hand.add(card);
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('C',8);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
		    int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(40,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_3() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(30,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_4() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',10);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(30,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_5() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',9);
			Hand.add(card);
			card = new Card('D',7);
			Hand.add(card);
			card = new Card('S',8);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(6,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_6() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',6);
			Hand.add(card);
			card = new Card('C',8);
			Hand.add(card);
			card = new Card('C',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(3,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_7() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',6);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',10);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_8() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',6);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void evalPPWinnings_test_0() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> Hand = new ArrayList<Card>();
			card = new Card('C',4);
			Hand.add(card);
			card = new Card('D',10);
			Hand.add(card);
			card = new Card('S',6);
			Hand.add(card);
			assertEquals(3,Hand.size(),"Wrong Size");
			int temp = ThreeCardLogic.evalPPWinnings(Hand, 1);
		    assertEquals(0,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void compareHands_test_1() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> player = new ArrayList<Card>();
			ArrayList<Card> dealer = new ArrayList<Card>();
			card = new Card('C',5);
			player.add(card);
			card = new Card('D',7);
			player.add(card);
			card = new Card('S',10);
			player.add(card);
			card = new Card('C',5);
			dealer.add(card);
			card = new Card('D',7);
			dealer.add(card);
			card = new Card('S',9);
			dealer.add(card);
			assertEquals(3,player.size(),"Wrong Size");
			assertEquals(3,dealer.size(),"Wrong Size");
			int temp = ThreeCardLogic.compareHands(dealer, player);
		    assertEquals(2,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void compareHands_test_2() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> player = new ArrayList<Card>();
			ArrayList<Card> dealer = new ArrayList<Card>();
			card = new Card('C',5);
			player.add(card);
			card = new Card('D',7);
			player.add(card);
			card = new Card('S',9);
			player.add(card);
			card = new Card('C',5);
			dealer.add(card);
			card = new Card('D',6);
			dealer.add(card);
			card = new Card('S',9);
			dealer.add(card);
			assertEquals(3,player.size(),"Wrong Size");
			assertEquals(3,dealer.size(),"Wrong Size");
			int temp = ThreeCardLogic.compareHands(dealer, player);
		    assertEquals(2,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void compareHands_test_3() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> player = new ArrayList<Card>();
			ArrayList<Card> dealer = new ArrayList<Card>();
			card = new Card('C',5);
			player.add(card);
			card = new Card('D',7);
			player.add(card);
			card = new Card('S',9);
			player.add(card);
			card = new Card('C',4);
			dealer.add(card);
			card = new Card('D',7);
			dealer.add(card);
			card = new Card('S',9);
			dealer.add(card);
			assertEquals(3,player.size(),"Wrong Size");
			assertEquals(3,dealer.size(),"Wrong Size");
			int temp = ThreeCardLogic.compareHands(dealer, player);
		    assertEquals(2,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void compareHands_test_0() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> player = new ArrayList<Card>();
			ArrayList<Card> dealer = new ArrayList<Card>();
			card = new Card('C',5);
			player.add(card);
			card = new Card('D',7);
			player.add(card);
			card = new Card('S',9);
			player.add(card);
			card = new Card('C',5);
			dealer.add(card);
			card = new Card('D',7);
			dealer.add(card);
			card = new Card('S',9);
			dealer.add(card);
			assertEquals(3,player.size(),"Wrong Size");
			assertEquals(3,dealer.size(),"Wrong Size");
			int temp = ThreeCardLogic.compareHands(dealer, player);
		    assertEquals(0,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void compareHands_test_5() {
		
		try {
			logic = new ThreeCardLogic();
			ArrayList<Card> player = new ArrayList<Card>();
			ArrayList<Card> dealer = new ArrayList<Card>();
			card = new Card('C',5);
			player.add(card);
			card = new Card('D',7);
			player.add(card);
			card = new Card('S',9);
			player.add(card);
			card = new Card('C',5);
			dealer.add(card);
			card = new Card('D',8);
			dealer.add(card);
			card = new Card('S',9);
			dealer.add(card);
			assertEquals(3,player.size(),"Wrong Size");
			assertEquals(3,dealer.size(),"Wrong Size");
			int temp = ThreeCardLogic.compareHands(dealer, player);
		    assertEquals(1,temp,"Wrong number");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	
}
