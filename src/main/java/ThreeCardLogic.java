import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.Scene;

public class ThreeCardLogic {
	public static int evalHand(ArrayList<Card> hand) {
		char suit1 = hand.get(0).getSuit();
		char suit2 = hand.get(1).getSuit();
		char suit3 = hand.get(2).getSuit();
		int value1 = hand.get(0).getValue();
		int value2 = hand.get(1).getValue();
		int value3 = hand.get(2).getValue();
		
		if(suit1 == suit2 && suit2 == suit3) {
			if(checkForStraight(value1, value2, value3, hand) == 1) {
				return 1;
			} else {
				return 4;
			}
		}
		if (value1 == value2 && value2 == value3) {
			return 2;
		}
		if(checkForStraight(value1, value2, value3, hand) == 1) {
			return 3;
		}
		if(value1 == value2 || value1 == value3 || value2 == value3) {
			return 5;
		}
		return 0;
	}
	
	public static int checkForStraight(int value1, int value2, int value3, ArrayList<Card> hand) {
		int minVal = getMinValue(hand)[0];
		int maxVal = getMaxValue(hand)[0];
		if(minVal == value1) {
			if(maxVal == value2) {
				if(value3 == value1 + 1 && value3 == value2 - 1) {
					return 1;
				}
			} else {
				if(value2 == value1 + 1 && value2 == value3 - 1) {
					return 1;
				}
			}
		} else if(minVal == value2) {
			if(maxVal == value1) {
				if(value3 == value2 + 1 && value3 == value1 - 1) {
					return 1;
				}
			} else {
				if(value1 == value2 + 1 && value1 == value3 - 1) {
					return 1;
				}
			}
		} else {
			if(maxVal == value1) {
				if(value2 == value3 + 1 && value2 == value1 - 1) {
					return 1;
				}
			} else {
				if(value1 == value3 + 1 && value1 == value2 - 1) {
					return 1;
				}
			}
		}
		return -1;
	}
	
	public static int[] getMinValue(ArrayList<Card> hand) {
		int[] minVal = new int[] {hand.get(0).getValue(), -1};
		for(int i  = 0; i < hand.size(); i++) {
			if(hand.get(i).getValue() < minVal[0]) {
				minVal[0] = hand.get(i).getValue();
				minVal[1] = i;
			}
		}
		return minVal;
	}
	
	public static int[] getMaxValue(ArrayList<Card> hand) {
		int[] MaxValue = new int[] {0,0};
		for(int i  = 0; i < hand.size(); i++) {
			if(hand.get(i).getValue() > MaxValue[0]) {
				MaxValue[0] = hand.get(i).getValue();
				MaxValue[1] = i;
			} 
		}
		return MaxValue;
	}
	
	public static int evalPPWinnings(ArrayList<Card> hand, int bet) {
		System.out.println(hand.get(0).getValue() +" " + hand.get(1).getValue() +" " + hand.get(2).getValue() );
		int winNumber = evalHand(hand);
		System.out.println("here here here ppwin number : " + winNumber);
		switch(winNumber) {
		   case 1:{
			   return 40*bet;
		   }
		   case 2:{
			   return 30*bet;
		   }
		   case 3:{
			   return 6*bet;
		   }
		   case 4:{
			   return 3*bet;
		   }
		   case 5:{
			   return 1*bet;
		   }
		   case 0:{
			   return 0;
		   }
		}
		return -1;
	}
	
	public static int compareHands(ArrayList<Card> dealer, ArrayList<Card> player) {
		int[] DealerMaxVal = getMaxValue(dealer);
		int[] playerMaxVal = getMaxValue(player);
		System.out.println("first compare" + DealerMaxVal[0] + playerMaxVal[0]);
		if(DealerMaxVal[0] > playerMaxVal[0]) {
			return 1;
		}
		if(DealerMaxVal[0] < playerMaxVal[0]) {
			return 2;
		}
		//---------------------------------------------------------------------
		int dealerSecondMax = 0;
		for(int i = 0; i < 3; i ++) {
			if(i == DealerMaxVal[1]) {
				continue;
			}
			if(dealer.get(i).getValue() > dealerSecondMax) {
				dealerSecondMax = dealer.get(i).getValue();
			}  
		}
		
		int playerSecondMax = 0;
		for(int i = 0; i < 3; i ++) {
			if(i == playerMaxVal[1]) {
				continue;
			}
			if(player.get(i).getValue() > playerSecondMax) {
				playerSecondMax = player.get(i).getValue();
			}  
		}
		
		System.out.println("second compare"+ dealerSecondMax + playerSecondMax);
		if(dealerSecondMax > playerSecondMax) {
			return 1;
		}
		if(dealerSecondMax < playerSecondMax) {
			return 2;
		}
		//---------------------------------------------------------------------
		DealerMaxVal = getMinValue(dealer);
		playerMaxVal = getMinValue(player);
		System.out.println("third compare"+ DealerMaxVal[0] + playerMaxVal[0]);
		if(DealerMaxVal[0] > playerMaxVal[0]) {
			return 1;
		}
		if(DealerMaxVal[0] < playerMaxVal[0]) {
			return 2;
		}
		//---------------------------------------------------------------------
		return 0;
	}
}
