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
    Player start, last;
    public Player startPlayer(){
        if (player1Name.compareTo(player2Name) > 0){
            start = player2;
            last = player1;
            return player2;
        }
        else{
            start = player1;
            last = player2;
            return player1;
        }
    }

    Player currPlayer;
    int currPlayerIndex = 1;
    public Player switchPlayers(){
        currPlayerIndex = 3 - currPlayerIndex;
        if (currPlayerIndex == 1)
            currPlayer = start;
        else
            currPlayer = last;

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

    public void winnerInOneRound (Card first, Card second, Player ownFirst, Player ownSecond, boolean wasWar){
        int finalNumberOfCards = centralDeck.numberOfCards;
        if (first.compare(second) == 1){
            for (int i = 0; i <finalNumberOfCards ; i++){
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
            for (int i = 0; i< finalNumberOfCards ; i++) {
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
        Card warFirst = null;
        Card warSecond = null;
        int i = 3;
        while (i > 0){
            if (ownFirst.outOfCards()){
                if (wasWar)
                    System.out.println(ownSecond.name + " won the war");
                else
                    System.out.println(ownSecond.name + " won");
                return;
            }
            warFirst = ownFirst.drawCard();
            centralDeck.addCard(warFirst);
            if (i > 1)
                System.out.println(ownFirst.name + " drew a war card");
            else
                System.out.println(ownFirst + " drew " + warFirst.toString());

            if (ownSecond.outOfCards()){
                if (wasWar)
                    System.out.println(ownFirst.name + " won the war");
                else
                    System.out.println(ownFirst.name + " won");
                return;
            }
            warSecond = ownSecond.drawCard();
            centralDeck.addCard(warSecond);
            if (i > 1)
                System.out.println(ownSecond.name + " drew a war card");
            else
                System.out.println(ownSecond + " drew " + warSecond.toString());

            i--;
        }
        wasWar = true;

        winnerInOneRound(warFirst,warSecond,ownFirst,ownSecond, wasWar);
    }

    public String start(){
        initializeGame();
        System.out.println("Initializing the game...");
        currPlayer = startPlayer();
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
            Player ownSecondCard = currPlayer;
            centralDeck.addCard(secondCard);
            currPlayer = switchPlayers();
            winnerInOneRound(firstCard,secondCard,ownFirstCard,ownSecondCard, false);
            n++;
        }
        if (player1.outOfCards()){
            return player2Name;
        }
        return player1Name;
    }


}
