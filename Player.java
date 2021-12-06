public class Player {
    private String name;

    public Player(String name){
        this.name = name;
        Deck playingDeck = new Deck (false);
        Deck winningDeck = new Deck(false);
    }

    public void addCard(Card card, boolean playingDeck){
        if(playingDeck)
            playingDeck.addCard(card);
    }
}
