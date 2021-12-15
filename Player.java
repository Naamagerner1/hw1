public class Player {
    private String name;
    private Deck playingDeck = new Deck (false);
    private Deck winningDeck = new Deck(false);

    public Player(String name){
        this.name = name;
    }

    /**
     * Adds the card to the relevant deck
     * @param card The card to add
     * @param playingDeck Boolean that represents if to add the card to the playing deck or the winning deck
     */
    public void addCard(Card card, boolean playingDeck){
        if(playingDeck)
            this.playingDeck.addCard(card);
        else
            this.winningDeck.addCard(card);
    }

    /**
     * Checks if playing deck is empty
     * If playing deck is empty and winning is not empty - shuffle winning deck and make it playing deck
     * Throws card from playing deck
     * @return The card that thrown out
     */
    Card cardToDraw;
    public Card drawCard(){
        if (playingDeck.isEmpty() && !winningDeck.isEmpty()) {
            winningDeck.Shuffle();
            playingDeck = winningDeck;
            winningDeck = new Deck(false);
        }
        cardToDraw = playingDeck.removeTopCard();
        return cardToDraw;
    }

    /**
     * Check if there are no cards in both decks
     * @return boolean answer
     */
    public boolean outOfCards(){
        if (playingDeck.isEmpty() && winningDeck.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * @return the player's name
     */
    public String toString(){
        return name;
    }
}
