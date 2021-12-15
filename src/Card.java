public class Card {
    private int number;
    private Suit suit;

    public Card(int number, Suit suit){
        this.number = number;
        this.suit = suit;
    }

    /**
     * @return The card's number
     */
    public int getNumber(){
        return number;
    }
    /**
     * @return The card's suit
     */
    public Suit getSuit(){
        return suit;
    }

    /**
     * Compare between two numbers of cards
     * @param other The other card
     * @return Number that represents the order of the cards
     */
    public int compare(Card other){
        if(number < other.number)
            return  -1;
        if(number == other.number)
            return 0;

        return  1;
    }

    /**
     * Match the suit to it's symbol
     * @param suit The suit
     * @return Suit's symbol
     */
    public String suitToString(Suit suit){
        if (suit == Suit.SPADES)
            return "♠";
        if (suit == Suit.DIAMONDS)
            return "♦";
        if (suit == Suit.CLUBS)
            return "♣";

        return "♥";
    }

    /**
     * Write number and suit in a sentence
     * @return Sentence of the card
     */
    public String toString(){
        if(number == 1)
            return ("Ace of " + suitToString(suit));
        else if(number == 11)
            return ("Jack of " + suitToString(suit));
        else if(number == 12)
            return ("Queen of " + suitToString(suit));
        else if(number == 13)
            return ("King of " + suitToString(suit));

        return (number + " of " + suitToString(suit));
    }
}
