import java.util.ArrayList;
import java.util.HashMap;

public class Deck extends ArrayList<Card> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Card> myList;
	
	public Deck() {
		myList = new ArrayList<>();
		this.myList = makeDeck(myList);
	}
	
	public ArrayList<Card> makeDeck(ArrayList<Card> List){
		HashMap<Integer, Boolean> alreadyStored = new HashMap<Integer, Boolean>();
		
		for(int i = 0; i < 52 ; i++) {
			int random = (int)(1 + Math.random() * (52-1+1));
			if(alreadyStored.containsKey(random) == true) {
				i--;
				continue;
			}
			alreadyStored.put(random,true);
			int suitNumber = random % 4;
			int value = (random-1) / 4 + 2;
			char suit;
			switch (suitNumber) {
			  case 1:{
				  suit = 'C';
				  break;
			  }
			  case 2:{
				  suit = 'D';
				  break;
			  }
			  case 3:{
				  suit = 'S';
				  break;
			  }
			  case 0:{
				  suit = 'H';
				  break;
			  }
			  default:{
				  throw new UnsupportedOperationException("Invalid Random");
			  }
		    }
			Card temp = new Card(suit, value);
			List.add(temp);
		}
		return List;
	}
	
	public ArrayList<Card> newDeck() {
		this.myList = new ArrayList<>();
		this.myList = makeDeck(myList);
		return this.myList;
	}
	
	public ArrayList<Card> getDeck() {
		return this.myList;
	}
	
	public void removeDeckItem(int i) {
		this.myList.remove(i);
	}
	
	public int getSizeOfDeck() {
		return this.myList.size();
	}
}
