import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class Deck {
	int[] myDeck = new int[52];
	public int[] makeDeck()
	{
		int index=0;
		
		for (int i = 2; i<=14;i++){ // there are 9 (2-10) numeric cards and 5 "special", for siplicty counting them as number
			for (int j=0;j<=3;j++){ // 4 shapes
				myDeck[index] = i;
				index++;
			}
		}
		shuffleArray(myDeck);
		return myDeck;
	}
	
	private void shuffleArray(int[] deck){ //Fisher-Yates shuffle
		Random rnd=ThreadLocalRandom.current();
		for(int i = deck.length-1; i>0;i--){
			
			int index = rnd.nextInt(i+1);
			int a = deck[index];
			deck[index]=deck[i];
			deck[i]=a;
		}
	}
	
	public int[] returnDeck(){return myDeck;	}
}
	

