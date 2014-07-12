import java.io.*;


public class BlackJackGame {

	/**
	 * @param args
	 * @throws IOException
	 */
	
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		Deck deck = new Deck(1, true);

		
		
		// players with 100 chips
		Player player = new Player("Player", 100);
		Player dealer = new Player("Dealer", 100);

		boolean deal = true;
		String start;
		while (deal) {
			player.emptyOnHand();
			dealer.emptyOnHand();
			
			System.out.println("Please choose Deal(D) or other to finish the game!");
			start = br.readLine();
			if (start.equalsIgnoreCase("D")) {
				if (player.getValueChips() > 0 && dealer.getValueChips()> 0) {
					// first cards
					player.addCard(deck.getNextCard());
					dealer.addCard(deck.getNextCard());

					// second cards
					player.addCard(deck.getNextCard());
					dealer.addCard(deck.getNextCard());

					// Dispaly initial hands
					System.out.println("Current status of cards on hand");
					player.displayCardsOnHand(true);
					dealer.displayCardsOnHand(false);
					System.out.println("\n");

					// how to finish the hitting
					boolean playerDone = false;
					boolean dealerDone = false;
					int blackjack = 0;

					String action;

					while (!playerDone || !dealerDone) {

						if (player.getValueOfOnHand() == 21
								&& dealer.getValueOfOnHand() == 21) {
							blackjack = 1;
							playerDone = true;
							dealerDone = true;

						} else if (player.getValueOfOnHand() == 21) {
							blackjack = 2;

							playerDone = true;

						} else if (dealer.getValueOfOnHand() == 21) {
							blackjack = 3;
							dealerDone = true;
						}
						// player turn
						while (!playerDone) {
							System.out
									.println(" Please Choose Hit(H) or Stay(S) !");
							action = br.readLine();
							if (action.equalsIgnoreCase("H")) {
								// add card to Deck and check the "Bust"
								// situation
								playerDone = !player
										.addCard(deck.getNextCard());
								player.displayCardsOnHand(true);

							} else {
								playerDone = true;
							}

						}

						if (player.getValueOfOnHand() > 21) {
							dealerDone = true;
							playerDone = true;

						}

						// dealer turn
						if (!dealerDone) {
							if (dealer.getValueOfOnHand() < 17
									&& !(player.getValueOfOnHand() > 21)) {
								System.out.println("The Dealer hits");
								dealerDone = !dealer
										.addCard(deck.getNextCard());
								dealer.displayCardsOnHand(false);
							} else {
								System.out.println("The Dealer Stays");
								dealerDone = true;
							}
						}
						System.out.println("\n");
					}

					

					// Display the final situation

					System.out.println("Final situation is :");
					player.displayCardsOnHand(true);
					System.out.println();
					dealer.displayCardsOnHand(true);
					System.out.println();
					int playerResult = player.getValueOfOnHand();
					int dealerResult = dealer.getValueOfOnHand();
					if (blackjack == 1) {
						System.out.println("It's tie!");
					} else if (blackjack == 2) {
						dealer.decreasChip();
						player.addChip();
						System.out.println("Black Jack!, Player won!");
					} else if (blackjack == 3) {
						player.decreasChip();
						dealer.addChip();
						System.out.println("Black Jack!, Dealer won!");
					} else if (playerResult > dealerResult
							&& playerResult <= 21) {
						dealer.decreasChip();
						player.addChip();
						System.out.println("Player won!");
					} else if (playerResult < dealerResult
							&& dealerResult <= 21) {
						player.decreasChip();
						dealer.addChip();
						System.out.println("Dealer won!");
					} else if (playerResult == 21 && dealerResult == 21) {
						System.out.println("It is tie!");
					} else if (playerResult > 21 && dealerResult <= 21) {
						player.decreasChip();
						dealer.addChip();
						System.out.println("Dealer won!");
					} else if (playerResult <= 21 && dealerResult > 21) {
						player.addChip();
						dealer.decreasChip();
						System.out.println("Player won!");
					} else if (playerResult == dealerResult) {
						System.out.println("It's a tie!");
					}
				} else {
					System.out.println(" Ther is no any chip to countinue the game! GAME IS OVER");
					if (player.getValueChips()== 0) {
						System.out.printf("%s won and his award is %d .\n",
								dealer.getName(), dealer.getValueChips());
					} else {
						System.out.printf("%s won and his award is %d .\n",
								player.getName(), player.getValueChips());
					}
					deal = false;
				}
			} else {
				deal = false;
			}
			System.out.println("");
		}
		br.close();
		System.out.println("END OF GAME!");
		System.out.printf("%s's gain %d .\n",player.getName(), player.getValueChips());
		System.out.printf("%s's gain %d .\n",dealer.getName(), dealer.getValueChips());
		
	}

	public static void askForDeal() {

	}
}
