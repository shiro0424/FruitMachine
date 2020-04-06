import java.util.Random;

public class Model {
	private int balance;
	private final String[] CARDS = {"Ace", "King", "Queen", "Jack", "Joker"};
	private Count count;
	
	public Model() {
		balance = 100;
		count = new Count();
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String[] getRandomCards() {
		String[] randomCards = new String[3];
		
		for(int i = 0; i < 3; i++) {
			Random rdm = new Random();
			int cardIndex = rdm.nextInt(CARDS.length);
			randomCards[i] = CARDS[cardIndex];
		}
		
		return randomCards;
	}
	
	public String getInfo(String[] cards) {
		String info = "";
		int jokerCount = count.jokerCount(cards);
		int maxCount = count.maxCount(cards);
		if(jokerCount > 0) {
			int losePoint = jokerCount * 25;
			balance -= losePoint;
			info = jokerCount + " jokers: you lose " + losePoint + " points";
		}else if(maxCount == 2) {
			balance += 20;
			info = "Two of a kind - you win 20 points";
		}else if(maxCount == 3) {
			balance += 50;
			info = "Three of a kind - you win 50 points";
		}else {
			info = "Balance unchanged";
		}
		
		return info;
	}
	
	public String getFinish() {
		String finishInfo = "";
		
		if(balance < 0) {
			finishInfo = "You lose";
		} else if(balance >= 150) {
			finishInfo = "You win!";
		}
		
		return finishInfo;
	}
}
