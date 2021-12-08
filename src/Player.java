public class Player {
    private String name;
    private Deck playingDeck = new Deck (false);
    private Deck winningDeck = new Deck(false);

    public Player(String name){
        this.name = name;
    }

    public void addCard(Card card, boolean playingDeck){
        if(playingDeck)
            this.playingDeck.addCard(card);
        else
            this.winningDeck.addCard(card);
    }

    public Card drawCard(){
        if (playingDeck.isEmpty() && !winningDeck.isEmpty()) {
            winningDeck.Shuffle();
            playingDeck = winningDeck;
            winningDeck = new Deck(false);
        }
        else if (playingDeck.isEmpty() && winningDeck.isEmpty()) {
            return null; //////////////////////////////////////////////////////////////////////
        }

        int index = playingDeck.numberOfCards - 1;
        Card temp = playingDeck.currentDeckArray[index];
        playingDeck.removeTopCard();
        return temp;
    }

    public boolean outOfCards(){
        if (drawCard() == null) {
            return true;
        }
        return false;
    }

    public String toString(){
        return name;
    }

}
