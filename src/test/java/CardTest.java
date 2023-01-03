import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class CardTest {
	private Card card;
	
	@Test
	void ConstructorTest() {
		card = new Card('C',5);
		assertEquals('C',card.getSuit(),"Wrong Suit");
		assertEquals(5,card.getValue(),"Wrong Value");
	}
	
    @Test
    public void shouldGetExceptionWhenNotInScale() {
        try {
        	card = new Card('A',5);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Invalid Suit"));
        }
    }
	
    @Test
    public void shouldGetExceptionWhenNotInScale2() {
        try {
        	card = new Card('C',0);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Invalid Value"));
        }
    }
    
    @Test
    public void shouldGetExceptionWhenNotInScale3() {
    	card = new Card('C',5);
        try {
        	card.setSuit('B');
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Invalid Suit"));
        }
    }
    
    @Test
    public void shouldGetExceptionWhenNotInScale4() {
    	card = new Card('H',10);
        try {
        	card.setValue(15);
            fail("should get IllegalArgumentException");
        } catch (IllegalArgumentException ex) {
            assertTrue(ex.getMessage().contains("Invalid Value"));
        }
    }

}
