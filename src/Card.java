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
    public String getSuit{
        return suit;
    }

    public int compare(Card other){
        if(number < other)
            return  -1;
        if(number == other)
            return 0;
        if(number > other)
            return  1;
    }

    public String toString(){
        if(number == 1)
            System.out.println("Ace of " + suit);
        else if(number == 11)
            System.out.println("Jack of " + suit);
        else if(number == 12)
            System.out.println("Queen of " + suit);
        else if(number == 13)
            System.out.println("King of " + suit);
        else
            System.out.println("Ace of " + suit);
    }
}
