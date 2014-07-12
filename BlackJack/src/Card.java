import java.awt.List;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author farhad
 * 
 */

    
public class Card {

    /**
     * Card constructor
     */
	
    public Card(String cardSymbol, int cardNum)  {
        this.cardSymbol = cardSymbol;
        if(cardNum>=1 && cardNum<=13){
            this.cardNum=cardNum;
        } else{
            System.err.println(cardNum + " is not valid!");
            System.exit(1);
        }
    }
    /**
     * The number of card , Ace: 1,14, Jack-Queen-King:11-13
     */
    private int cardNum;

    /**
     * The symbol of the card.
     */

    private String cardSymbol;

    /**
     * Return the number of card
     */
    public int getNumberOfCard() {
        return this.cardNum;
    }

    public String toString() {
        String numberToString="Error";
        switch (this.cardNum) {
            case 2:
                numberToString = "Two";
                break;
            case 3:
                numberToString = "Three";
                break;
            case 4:
                numberToString = "Four";
                break;
            case 5:
                numberToString = "Five";
                break;
            case 6:
                numberToString = "Six";
                break;
            case 7:
                numberToString = "Seven";
                break;
            case 8:
                numberToString = "Eight";
                break;
            case 9:
                numberToString = "Nine";
                break;
            case 10:
                numberToString = "Ten";
                break;
            case 11:
                numberToString = "Jack";
                break;
            case 12:
                numberToString = "Queen";
                break;
            case 13:
                numberToString = "King";
                break;
            
            case 1:
                numberToString = "Ace";
                break;
        }
        return (numberToString+ " of " + cardSymbol.toString());

    }
}
