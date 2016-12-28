
import java.util.*;
public class Player {
	List<Integer> cards = new ArrayList<Integer>();
	
	
	List<Integer> makeCards(int[] deck, int player){	
		List<Integer> cards = new ArrayList<Integer>();
		switch (player){ // can't think of any other easy way of doing this
		case 1:
			for(int i = 0; i < 26; i++){
				cards.add(deck[i]);
			}
			break;
		case 2:
			for(int i = 26; i<=51;i++){
				cards.add(deck[i]);
			}
			break;
		}
		return cards;
	}//end of function
	
	List<Integer> shuffleCards(List<Integer> playerCards){ // for fixing stuck games
		Collections.shuffle(playerCards);
		return playerCards;

	}
}
