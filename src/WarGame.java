public class WarGame {
    private String player1Name;
    private String player2Name;
    private Player player1;
    private Player player2;
    Deck centralDeck = new Deck(true);


    public WarGame(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }



    public String getPlayer1() {
        return player1Name;
    }

    public String getPlayer2() {

        return player2Name;
    }

    int currPlayerIndex = 0;
    public Player startPlayer(){
        if (player1Name.compareTo(player2Name) == 1){
            currPlayerIndex= 1;
            return player1;
        }
        currPlayerIndex = 2;
        return player2;
    }
    Player currPlayer;
    public Player switchPlayers(){
        currPlayerIndex = 3 - currPlayerIndex;
        if (currPlayerIndex == 1)
            currPlayer = player1;
        else
            currPlayer = player2;

        return currPlayer;
    }

    public void initializeGame () {
        Player player1 = new Player(player1Name); /////////////////////////////////////////////
        Player player2 = new Player(player2Name); //////////////////////////////////////
        Player currPlayer =  startPlayer();
        while (centralDeck.numberOfCards > 0) {
            Card temp = centralDeck.removeTopCard();
            currPlayer.addCard(temp, true);
            currPlayer = switchPlayers();
            //currPlayerIndex = 3 - currPlayerIndex;
            //if (currPlayerIndex == 1)
            //    currPlayer = player1;
            //else
            //    currPlayer = player2;
        }
    }

    public Player winnerInOneRound (Card first, Card second, Player ownFirstCard, Player ownSecondCard){
        if (first.compare(second) == 1){
            for (int i = 0; i< centralDeck.numberOfCards ; i++){
                Card toWinner = centralDeck.removeTopCard();
                ownFirstCard.addCard(toWinner,false);
            }
            return ownFirstCard;
        }
        else if (first.compare(second) == -1){
            for (int i = 0; i< centralDeck.numberOfCards ; i++){
                Card toWinner = centralDeck.removeTopCard();
                ownSecondCard.addCard(toWinner,false);
        }
        else{
            currPlayer = switchPlayers();
            for (int i=3; i > 0 ; i--){
                Card warFirst = ownFirstCard.drawCard();//////////////////////////////////////////////////////////////
            }
        }
    }

    public String start(){
        initializeGame();
        System.out.println("Initializing the game...");
        Player currPlayer = startPlayer();
        Card first = currPlayer.drawCard();
        Player ownFirstCard = currPlayer;
        centralDeck.addCard(first);
        currPlayer = switchPlayers();
        Card second = currPlayer.drawCard();
        centralDeck.addCard(second);
        if (first.compare(second) == 1){
            ownFirstCard.addCard(first,false);
            ownFirstCard.addCard(second,false);
        }
        else if (first.compare(second) == -1){
            currPlayer.addCard(first,false);
            currPlayer.addCard(second,false);
        }
        else{
            currPlayer = switchPlayers();
            for ()
        }






    }


}
