import java.util.ArrayList;

public class Dealer {
	private Deck theDeck;
	private ArrayList<Card> dealersHand;
	
	public Dealer(){
		theDeck = new Deck();
		dealersHand = new ArrayList<Card>();
		for(int i = 0; i < 3; i++) {
			dealersHand.add(theDeck.getDeck().get(0));
			theDeck.removeDeckItem(0);
		}
	}
	
	public int remainCard() {
		return theDeck.getDeck().size();
	}
	
	public ArrayList<Card> dealHand() { //getDeckFirstThreeCard()
		ArrayList<Card> temp = new ArrayList<Card>();
		if(theDeck.getSizeOfDeck() <= 34) {
			theDeck.newDeck();
		}
		for(int i = 0; i < 3; i++) {
			temp.add(theDeck.getDeck().get(0));
			theDeck.removeDeckItem(0);
		}
		return temp;
	}
	
	public ArrayList<Card> getDealersHand(){
	    return dealersHand;
	}
	
	public void reSetDealersHand() {
		dealersHand = new ArrayList<Card>();
		if(theDeck.getSizeOfDeck() <= 34) {
			theDeck.newDeck();
		}
		for(int i = 0; i < 3; i++) {
			dealersHand.add(theDeck.getDeck().get(0));
			theDeck.removeDeckItem(0);
		}
	}
}
