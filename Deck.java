public class Deck {
    private Card[] currentDeckArray = new Card[52];
    private int numberOfCards = 0;

    /**
     * Creates a deck with 52 cards
     * Each card gets a number and suit
     * @param answer The answer if build full deck or empty deck
     */
    public Deck(boolean answer){
        int counterCards = 0;
        if(answer) {
            while (counterCards < 52) {
                for (Suit currentSuit : Suit.values())
                    for (int j = 1; j < 14; j++) {
                        currentDeckArray[counterCards] = new Card(j, currentSuit);
                        counterCards++;
                    }
                }
            }
            numberOfCards = counterCards;
        }

    /**
     * Add card to the deck
     * @param card The card to add
     */
    public void addCard(Card card){
        currentDeckArray[numberOfCards] = card;
        numberOfCards++;
    }

    /**
     * Removes the last card in the deck array
     * Updates the number of cards in deck
     * @return the card that was removed
     */
    public Card removeTopCard(){
        Card cardToRemove = currentDeckArray[numberOfCards - 1];
        currentDeckArray[numberOfCards - 1] = null;
        numberOfCards--;
        return cardToRemove;
    }

    /**
     * Check if there are no cards in deck
     * @return boolean answer
     */
    public boolean isEmpty(){
        if(numberOfCards == 0)
            return true;
        else
            return false;
    }

    /**
     * Shuffle the cards in the deck
     * Using rnd from Main.java
     */
    int next;
    Card tempCard;
    public void Shuffle(){
        int i = 0;
        while(i < numberOfCards) {
            next = Main.rnd.nextInt(numberOfCards);
            tempCard = currentDeckArray[next];
            currentDeckArray[next] = currentDeckArray[i];
            currentDeckArray[i] = tempCard;
            i++;
        }
    }

    /**
     * @return The number of cards in deck
     */
    public int getNumberOfCards(){
        return numberOfCards;
    }
}
