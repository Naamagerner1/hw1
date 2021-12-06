import java.util.Random;

public class Deck {
    private Card[] currentDeckArray = new Card[52];
    private String[] suitArray = {"SPADES", "DIAMONDS", "CLUBS", "HEARTS"};
    private int numberOfCards = 0;

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
            numberOfCards = counter+1;
        }
    }

    public void addCard(Card card){
        currentDeckArray[numberOfCards] = card;
    }

    Card removeTopCard(){
        Card cardToRemove = currentDeckArray[numberOfCards - 1];
        currentDeckArray[numberOfCards - 1] = null;
        return cardToRemove;
    }

    boolean isEmpty(){
        if(numberOfCards == 0)
            return true;
        else
            return false;
    }
    int next;
    Card temporary;
    int i = 0;
    void Shuffle(){
        for( ; i < numberOfCards; i++)
            next = Main.rnd.nextInt(numberOfCards - 1);
            temporary = currentDeckArray[next];
            currentDeckArray[next] = currentDeckArray[i];
            currentDeckArray[i] = temporary;
    }
}
