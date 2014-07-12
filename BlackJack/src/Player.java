import java.util.ArrayList;
import java.util.jar.Attributes.Name;


public class Player {


	private String playerName;
	private ArrayList<Card> onHand= new ArrayList<Card>();
	private int numberOfCards;
	private int chips;
	
	public Player(String playerName, int chips){
		this.playerName=playerName;
		this.chips=chips;
	}

	public void addChip(){
		this.chips++;
	}
	
	public int getValueChips(){
		return chips;
	}
	public void decreasChip(){
		this.chips--;
	}
	public void emptyOnHand() {
		this.onHand.clear();
		this.numberOfCards=0;
	}
	 
	public String getName(){
		return playerName;
	}
	public boolean addCard(Card card){
		
		// warn the user if we add more that 10 cards
		if(this.numberOfCards==10){
			System.err.printf("%s 's hand already has 10 cards \n", this.playerName);
			System.exit(1);
		}
		this.onHand.add(card);
		this.numberOfCards++;
		
	
		return (this.getValueOfOnHand()<=21);
	}

	public int getValueOfOnHand() {
		 int value=0;
		 int cardNumber=0;
		 int numberOfAce=0;
				 for(Card c:this.onHand){
					 cardNumber=c.getNumberOfCard();
					 if(cardNumber==1){ //Ace
						 numberOfAce++;
						 value+=11; 
					 }else if(cardNumber>10){
						value+=10;
					 }else{
						 value+=cardNumber;
					 }
					 //Convert the Ace value to 1 if it is neccessary
					 while(value >21 && numberOfAce>0)
						 value-=10;
					     numberOfAce--;
				 }
		return value;
	}
	
	public void displayCardsOnHand(boolean showFirst){
		System.out.printf("%s 's cards :\n", this.playerName);
		for(Card c: this.onHand){
			if(!this.onHand.get(0).equals(c) && !showFirst ){
				System.out.println(" [No Display]");
			}else {
				System.out.printf(" %s \n",c.toString());
			}
		}
		if(showFirst ){
		System.out.printf("Value of cards for %s:  %d \n",this.playerName ,this.getValueOfOnHand());
		}
	}
}
