
public class Count {
	public Count() {
		
	}
	
	public int jokerCount(String[] cards) {
		int count = 0;
		
		for(int i = 0; i < 3; i++) {
			if(cards[i].equals("Joker")) {
				count++;
			}
		}
		
		return count;
	}
	
	public int maxCount(String[] cards) {
		int count = 1;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i != j && cards[i].equals(cards[j])) {
					count++;
				}
			}
			
			if(count > 1) {
				break;
			}
		}
		
		return count;
	}
}
