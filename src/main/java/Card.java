
public class Card {
	private char suit;
	private int value;
	
	public Card(char Suit, int Value){
		if(Suit != 'C' && Suit != 'D' && Suit != 'S' && Suit != 'H') {
			throw new IllegalArgumentException("Invalid Suit");
		}
		if(Value < 2 || Value > 14) {
			throw new IllegalArgumentException("Invalid Value");
		}
		this.suit = Suit;
		this.value = Value;
	}
	
	public char getSuit() {
		return this.suit;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setSuit(char Suit) {
		if(Suit != 'C' && Suit != 'D' && Suit != 'S' && Suit != 'H') {
			throw new IllegalArgumentException("Invalid Suit");
		}
		this.suit = Suit;
	}
	
	public void setValue(int Value) {
		if(Value < 2 || Value > 14) {
			throw new IllegalArgumentException("Invalid Value");
		}
		this.value = Value;
	}
}
