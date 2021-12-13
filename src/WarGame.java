public class WarGame {
    protected String player1Name;
    private String player2Name;
    private Player player1;
    private Player player2;
    Deck centralDeck = new Deck(true);


    public WarGame(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
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
            currPlayerIndex= 2;
            return player2;
        }
        currPlayerIndex = 1;
        return player1;
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
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        centralDeck.Shuffle();
        Player currPlayer =  startPlayer();
        while (centralDeck.numberOfCards > 0) {
            Card temp = centralDeck.removeTopCard();
            currPlayer.addCard(temp, true);
            currPlayer = switchPlayers();
        }
    }
    Card first;

    public void winnerInOneRound (Card first, Card second, Player ownFirst, Player ownSecond, boolean wasWar){
        if (first.compare(second) == 1){
            for (int i = 0; i< centralDeck.numberOfCards ; i++){
                Card toWinner = centralDeck.removeTopCard();
                ownFirst.addCard(toWinner,false);
            }
            if (wasWar)
                System.out.println(ownFirst.name + " won the war");
            else
                System.out.println(ownFirst.name + " won");
            return;

        }
        else if (first.compare(second) == -1){
            for (int i = 0; i< centralDeck.numberOfCards ; i++) {
                Card toWinner = centralDeck.removeTopCard();
                ownSecond.addCard(toWinner, false);
            }
            if (wasWar)
                System.out.println(ownSecond.name + " won the war");
            else
                System.out.println(ownSecond.name + " won");
            return;

        }
        System.out.println("Starting a war...");
        wasWar = true;
        Card warFirst, warSecond;
        int i = 3;
        do{
            if (ownFirst.outOfCards()){
                if (wasWar)
                    System.out.println(ownSecond.name + " won the war");
            }
            warFirst = ownFirst.drawCard();
            centralDeck.addCard(warFirst);
            if (i > 1)
                System.out.println(ownFirst.name + " drew a war card");

            if (ownSecond.outOfCards()){
                if (wasWar)
                    System.out.println(ownFirst.name + " won the war");
            }
            warSecond = ownSecond.drawCard();
            centralDeck.addCard(warSecond);
            if (i > 1)
                System.out.println(ownSecond.name + " drew a war card");

            i--;
        }
        while (i > 0);
        winnerInOneRound(warFirst,warSecond,ownFirst,ownSecond, wasWar);
    }

    public String start(){
        initializeGame();
        System.out.println("Initializing the game...");
        Player currPlayer = startPlayer();
        int n = 1;
        while (!player1.outOfCards() && !player2.outOfCards()){
            System.out.println("------------------------- Round number " + n +" -------------------------");
            Card firstCard = currPlayer.drawCard();
            System.out.println(currPlayer + " drew " + firstCard.toString());
            Player ownFirstCard = currPlayer;
            centralDeck.addCard(firstCard);
            currPlayer = switchPlayers();
            Card secondCard = currPlayer.drawCard();
            System.out.println(currPlayer + " drew " + secondCard.toString());
            centralDeck.addCard(secondCard);
            winnerInOneRound(firstCard,secondCard,ownFirstCard,currPlayer, false);
            n++;

        }
        if (player1.outOfCards()){
            return player2Name;
        }
        return player1Name;
    }


}
