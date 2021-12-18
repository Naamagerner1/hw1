public class WarGame {
    private String player1Name;
    private String player2Name;
    private Player player1;
    private Player player2;
    private Deck centralDeck = new Deck(true);

    /**
     * Sets the players names
     * Initialize the players
     * @param player1Name The name of the first player
     * @param player2Name The name of the second player
     */
    public WarGame(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    /**
     * @return The first player's name
     */
    public String getPlayer1() {
        return player1Name;
    }

    /**
     * @return The second player's name
     */
    public String getPlayer2() {
        return player2Name;
    }

    /**
     * Compare between the names of the players
     * Sets the start and the last player
     * @return The start player
     */
    Player start, last;
    public Player startPlayer(){
        if (player1Name.compareTo(player2Name) > 0){
            start = player2;
            last = player1;
            return player2;
        }
        start = player1;
        last = player2;
        return player1;
    }

    /**
     * Switch between the current player to the other
     * @return The new current player
     */
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

    /**
     * Shuffles the central deck
     * Dividing the cards to the players
     */
    public void initializeGame () {
        centralDeck.Shuffle();
        Player currPlayer =  startPlayer();
        while (centralDeck.getNumberOfCards() > 0) {
            Card tempCard = centralDeck.removeTopCard();
            currPlayer.addCard(tempCard, true);
            currPlayer = switchPlayers();
        }
    }

    /**
     * Compares between the number of two cards
     * Prints the winner in the round
     * Adds the cards to the winning deck of the winner
     * In case of a war - does and prints the war steps, in order to sets the winner the method calls itself
     * @param first The first card
     * @param second The second card
     * @param ownFirst The player who throw the first card
     * @param ownSecond The player who throw the second card
     * @param wasWar Boolean flag, true means that was a war
     */
    public void winnerInOneRound (Card first, Card second, Player ownFirst, Player ownSecond, boolean wasWar){
        int finalNumberOfCards = centralDeck.getNumberOfCards();
        if (first.compare(second) == 1){
            for (int i = 0; i <finalNumberOfCards ; i++){
                Card toWinner = centralDeck.removeTopCard();
                ownFirst.addCard(toWinner,false);
            }
            if (wasWar)
                System.out.println(ownFirst.toString() + " won the war");
            else
                System.out.println(ownFirst.toString() + " won");
            return;

        }
        else if (first.compare(second) == -1){
            for (int i = 0; i< finalNumberOfCards ; i++) {
                Card toWinner = centralDeck.removeTopCard();
                ownSecond.addCard(toWinner, false);
            }
            if (wasWar)
                System.out.println(ownSecond.toString() + " won the war");
            else
                System.out.println(ownSecond.toString() + " won");
            return;

        }
        System.out.println("Starting a war...");
        Card warFirst = null;
        Card warSecond = null;
        int i = 3;
        while (i > 0){
            if (ownFirst.outOfCards()){
                if (wasWar)
                    System.out.println(ownSecond.toString() + " won the war");
                else
                    System.out.println(ownSecond.toString() + " won");
                return;
            }
            warFirst = ownFirst.drawCard();
            centralDeck.addCard(warFirst);
            if (i > 1)
                System.out.println(ownFirst.toString() + " drew a war card");
            else
                System.out.println(ownFirst + " drew " + warFirst.toString());

            if (ownSecond.outOfCards()){
                if (wasWar)
                    System.out.println(ownFirst.toString() + " won the war");
                else
                    System.out.println(ownFirst.toString() + " won");
                return;
            }
            warSecond = ownSecond.drawCard();
            centralDeck.addCard(warSecond);
            if (i > 1)
                System.out.println(ownSecond.toString() + " drew a war card");
            else
                System.out.println(ownSecond + " drew " + warSecond.toString());

            i--;
        }
        wasWar = true;

        winnerInOneRound(warFirst,warSecond,ownFirst,ownSecond, wasWar);
    }

    /**
     * Full game - the game will continue as long as both players own cards
     * @return The winner's name
     */
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
