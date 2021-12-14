import java.util.Random;

public class Deck {
    protected Card[] currentDeckArray = new Card[52];
    private String[] suitArray = {"♠", "♦", "♣", "♥"};
    protected int numberOfCards = 0;
    //private int counter

    public Deck(boolean answer){
        int counter = 0;
        if(answer) {
            while (counter < 52) {
                for (String currentSuit : suitArray)
                    for (int j = 1; j < 14; j++) {
                        currentDeckArray[counter] = new Card(j, currentSuit);
                        counter++;
                    }
            }
            numberOfCards = counter;
        }
    }

    public void addCard(Card card){
        currentDeckArray[numberOfCards] = card;
        numberOfCards++;
    }

    public Card removeTopCard(){
        Card cardToRemove = currentDeckArray[numberOfCards - 1];
        currentDeckArray[numberOfCards - 1] = null;
        numberOfCards--;
        return cardToRemove;
    }

    public boolean isEmpty(){
        if(numberOfCards == 0)
            return true;
        else
            return false;
    }
    int next;
    Card temporary;
    public void Shuffle(){
        int i = 0;

        while(i < numberOfCards) {
            next = Main.rnd.nextInt(numberOfCards);
            temporary = currentDeckArray[next];
            currentDeckArray[next] = currentDeckArray[i];
            currentDeckArray[i] = temporary;
            i++;
        }
    }
}
