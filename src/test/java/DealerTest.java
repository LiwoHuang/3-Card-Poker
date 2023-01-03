import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DealerTest {

	private Dealer dealer;
	
	@Test
	void remainCard_test_1() {
		
		try {
			dealer = new Dealer();
			ArrayList<Card> temp = new ArrayList<Card>();
			int temp_num = dealer.remainCard();
			assertEquals(49,temp_num,"Wrong Size");
			dealer = new Dealer();
			temp = new ArrayList<Card>();
			temp_num = dealer.remainCard();
			assertEquals(49,temp_num,"Wrong Size");
			dealer = new Dealer();
			temp = new ArrayList<Card>();
			temp_num = dealer.remainCard();
			assertEquals(49,temp_num,"Wrong Size");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void Constructor_test() {
		
		try {
			dealer = new Dealer();
			ArrayList<Card> temp = new ArrayList<Card>();
			int temp_num = dealer.remainCard();
			assertEquals(49,temp_num,"Wrong Size");
			temp = dealer.getDealersHand();
			assertEquals(3,temp.size(),"Wrong Size");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void getDealersHand_test_1() {
		
		try {
			dealer = new Dealer();
			ArrayList<Card> temp = new ArrayList<Card>();
			int temp_num = dealer.remainCard();
			assertEquals(49,temp_num,"Wrong Size");
			temp = dealer.getDealersHand();
			assertEquals(3,temp.size(),"Wrong Size");
			
			dealer = new Dealer();
			temp_num = dealer.remainCard();
			assertEquals(49,temp_num,"Wrong Size");
			temp = dealer.getDealersHand();
			assertEquals(3,temp.size(),"Wrong Size");
			
			dealer = new Dealer();
			temp_num = dealer.remainCard();
			assertEquals(49,temp_num,"Wrong Size");
			temp = dealer.getDealersHand();
			assertEquals(3,temp.size(),"Wrong Size");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void dealHand_test_1() {
		
		try {
			dealer = new Dealer();
			int remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			ArrayList<Card> deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
			deal_Hand = dealer.dealHand();
			remain_card = dealer.remainCard();
			assertEquals(46,remain_card,"Wrong Size");
			deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
			deal_Hand = dealer.dealHand();
			remain_card = dealer.remainCard();
			assertEquals(43,remain_card,"Wrong Size");
			deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void dealHand_test_2() {
		
		try {
			dealer = new Dealer();
			int remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			ArrayList<Card> deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
					
			while (remain_card > 34 && remain_card < 52) {
				deal_Hand = dealer.dealHand();
				remain_card = dealer.remainCard();
				deal_Hand = dealer.getDealersHand();
				assertEquals(3,deal_Hand.size(),"Wrong Size");
			}
			assertEquals(34,remain_card,"Wrong Size");
			deal_Hand = dealer.dealHand();
			remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void dealHand_test_3() {
		
		try {
			dealer = new Dealer();
			int remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			ArrayList<Card> deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
					
			while (remain_card > 34 && remain_card < 52) {
				deal_Hand = dealer.dealHand();
				remain_card = dealer.remainCard();
				deal_Hand = dealer.getDealersHand();
				assertEquals(3,deal_Hand.size(),"Wrong Size");
			}
			deal_Hand = dealer.dealHand();
			deal_Hand = dealer.dealHand();
			remain_card = dealer.remainCard();
			deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
			remain_card = dealer.remainCard();
			assertEquals(46,remain_card,"Wrong Size");
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void remainCard_test_2() {
		
		try {
			dealer = new Dealer();
			int remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			ArrayList<Card> deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
					
			for(int i = 0; i < 3; i++) {
				deal_Hand = dealer.dealHand();
			}
			
			remain_card = dealer.remainCard();
			assertEquals(40,remain_card,"Wrong Size");
			deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
			
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void remainCard_test_3() {
		
		try {
			dealer = new Dealer();
			int remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			ArrayList<Card> deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
					
			for(int i = 0; i < 14; i++) {
				deal_Hand = dealer.dealHand();
			}
			
			remain_card = dealer.remainCard();
			assertEquals(43,remain_card,"Wrong Size");
			deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
			
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void remainCard_test_4() {
		
		try {
			dealer = new Dealer();
			int remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			ArrayList<Card> deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
					
			for(int i = 0; i < 11; i++) {
				deal_Hand = dealer.dealHand();
			}
			
			remain_card = dealer.remainCard();
			assertEquals(34,remain_card,"Wrong Size");
			deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
			
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	@Test
	void remainCard_test_5() {
		
		try {
			dealer = new Dealer();
			int remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			ArrayList<Card> deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
					
			for(int i = 0; i < 12; i++) {
				deal_Hand = dealer.dealHand();
			}
			
			remain_card = dealer.remainCard();
			assertEquals(49,remain_card,"Wrong Size");
			deal_Hand = dealer.getDealersHand();
			assertEquals(3,deal_Hand.size(),"Wrong Size");
			
			
        	
        } catch (IllegalArgumentException ex) {
        	assertFalse(ex.getMessage().contains("Invalid Random"));
        	assertFalse(ex.getMessage().contains("Invalid Suit"));
            assertFalse(ex.getMessage().contains("Invalid Value"));
        }
			
	}
	
	

}

