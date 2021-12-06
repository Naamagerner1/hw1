public class Card {
    private int number;
    private String suit;

    public Card(int number, String suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNumber(){
        return number;
    }
    public String getSuit(){
        return suit;
    }

    public int compare(Card other){
        if(number < other.number)
            return  -1;
        if(number == other.number)
            return 0;

        return  1;
    }

    public String toString(){
        if(number == 1)
            return ("Ace of " + suit);
        else if(number == 11)
            return ("Jack of " + suit);
        else if(number == 12)
            return ("Queen of " + suit);
        else if(number == 13)
            return ("King of " + suit);

        return (number + " of " + suit);
    }
}
