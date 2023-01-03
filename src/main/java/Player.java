import java.util.ArrayList;

public class Player {
	private ArrayList<Card> hand;
	private int anteBet;
	private int playBet;
	private int pairPlusBet;
	private int totalWinnings;
	
	public Player() {
		hand = new ArrayList<Card>();
		anteBet = 0;
		playBet = 0;
		pairPlusBet = 0;
		totalWinnings = 0;
	}
	
	public void setAnteBet(int bet) {
		this.anteBet = bet;
	}
	public void setPlayBet(int bet) {
		this.playBet = bet;
	}
	public void setPairPlusBet(int bet) {
		this.pairPlusBet = bet;
	}
	public void setTotalWinnings(int win) {
		this.totalWinnings = win;
	}
	
	public int getAnteBet() {
		return this.anteBet;
	}
	public int getPlayBet() {
		return this.playBet;
	}
	public int getPairPlusBet() {
		return this.pairPlusBet;
	}
	public int getTotalWinnings() {
		return this.totalWinnings;
	}
	
	public void setHand(ArrayList<Card> card) {
		this.hand = card;
	}
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
}
