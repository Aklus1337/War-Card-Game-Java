import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class warr {

	public static void main(String[] args) throws java.lang.Exception{
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("How many games would you like to simulate?");
		int numberOfGames = Integer.parseInt(scan.readLine());
		int[] result = runWar(numberOfGames);
		System.out.println("Player 1 won "+result[0]+" time(s), and player 2 won "+result[1]+" time(s)");
	}
	
	static int[] runWar(int numberOfGames){
		int player1Wins = 0;
		int player2Wins = 0;
		while(numberOfGames>0){
			numberOfGames--; //everytime we lower the amount of games left
			//start init of our game
			
			List<Integer> table = new ArrayList<Integer>();
			Player player = new Player();
			Deck mainDeck = new Deck();
			mainDeck.makeDeck();
			List<Integer> player1=player.makeCards(mainDeck.returnDeck(), 1);
			List<Integer> player2=player.makeCards(mainDeck.returnDeck(), 2);
			int iterations=0;
			//end of init
			while(player1.size() > 4 && player2.size() > 4) // we need at least 4 cards as war needs 4 cards
			{
				iterations++;
				table.add(player1.get(0));
				table.add(player2.get(0));
				if(player1.get(0) == player2.get(0)){//same cards mean war
					table.add(player1.get(1));
					table.add(player2.get(1));
					player1.remove(1);
					player2.remove(1);
				}
				else if(player2.get(0) > player1.get(0)){ // player 2 wins
					for(int i=0;i<table.size();i++){
						player2.add(table.get(i));// add all items from table to player
					}
					table.clear();
				}
				else{ // player 1 wins
					for(int i=0;i<table.size();i++){
						player1.add(table.get(i)); // add all items from table to player
					}
					table.clear();
				}

				player1.remove(0);
				player2.remove(0);
				if(iterations>1000){ // game might be stuck sometimes. shuffling when 1000 cards has been played in 1 game
					player1 = player.shuffleCards(player1);
					player2 = player.shuffleCards(player2); 
				}
			}// end of 1 game
			if(player1.size() > player2.size()) // player with all/more cards wins
			{
				player1Wins++;
			}else{player2Wins++;}
		} // end of main loop with numberOfGames
		return new int[] {player1Wins, player2Wins};
	}



} 