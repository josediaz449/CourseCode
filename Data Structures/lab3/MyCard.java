package lab3;

import java.util.ArrayList;
import java.util.Random;

public class MyCard implements Card{
	ArrayList<String> deck = new ArrayList<String>();
	@Override
	public void initialize() {
		String[] letter = new String[] {"S", "C", "H", "D"};
		for(int i = 1;i<14;i++) {
			for(int j = 0;j<4;j++) {
				deck.add(i+letter[j]);
			}
		}
		
		
	}

	@Override
	public String drawCard() {
		Random rnd = new Random();
		int randNum = rnd.nextInt(deck.size());
		String card = deck.get(randNum);
		deck.remove(randNum);
		return card;
	}
	
	public static void main(String[] args) {
		MyCard myCard = new MyCard();
		myCard.initialize();
		
		for(int i = 0;i<52;i++) {
			System.out.println(myCard.drawCard());
		}

	}

}
