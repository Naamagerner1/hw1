public class Player {
    protected String name;
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
    Card cardToDraw;
    public Card drawCard(){
        //if (playingDeck.isEmpty() && winningDeck.isEmpty())
            //return null;

        if (playingDeck.isEmpty() && !winningDeck.isEmpty()) {
            winningDeck.Shuffle();
            playingDeck = winningDeck;
            winningDeck = new Deck(false);
        }

        //int index = playingDeck.numberOfCards - 1;
        //temp = playingDeck.currentDeckArray[index];
        cardToDraw = playingDeck.removeTopCard();
        return cardToDraw;
    }

    public boolean outOfCards(){
        if (playingDeck.isEmpty() && winningDeck.isEmpty()) {
            return true;
        }
        return false;
    }

    public String toString(){
        return name;
    }

}
