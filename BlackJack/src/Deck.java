
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import java.util.Arrays;
import java.util.Collections;
/**
 *
 * @author farhad
 */
public class Deck {

	 public  static final String[]  SYMBOL=new String[]{"Hearts","Diamonds","Clubs","Spades"};
    /**
     * 
     */
    private Card[] cards;
    private int numberOfCards;
    
    /**
     * default deck (1 deck , 52 cards and with shuffling)
     */
    public Deck(){
        this(1,true);
    }
    
    public Deck(int numberOfDecks, boolean shuffle) {
        this.numberOfCards = numberOfDecks*52;
        this.cards=new Card[this.numberOfCards];
        
        int index=0;
        //for each deck
        for(int i=0;i<numberOfDecks;i++){
            //for each symbol
            for(int j=0;j<4;j++){
                //for each number 
                for(int k=1;k<=13;k++){
                    // add a new card to deck (symbol and card Number)
                    this.cards[index]=new Card(SYMBOL[j],k);
                    index++;
                }
                
            }   
        }
        if(shuffle){
            this.shuffleCards();
        }      
    }
    
     private void shuffleCards() {
      // Thanks to Collections which provides shuffle method 
        Collections.shuffle(Arrays.asList(this.cards));       
    }
     
      public Card getNextCard() {
        //get first card
        Card topCard = this.cards[0];
        for(int i=1;i<this.numberOfCards;i++){
            this.cards[i-1]=this.cards[i];
        }
        this.cards[this.numberOfCards-1]=null;
        // decrease the number of card in deck
        this.numberOfCards--;
        return topCard;
    }
      
      public void printDeck(int numberToDisplay){
          for(int i=0;i<numberToDisplay;i++){
               System.out.printf("% 3d/%d %s \n",i+1 ,this.numberOfCards, this.cards[i].toString());
          }
          System.out.printf("\t [%d Cards Left]\n",this.numberOfCards-numberToDisplay);
         
      }
}
