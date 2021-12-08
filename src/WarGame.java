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
    public Player startPlayer(){
        if (player1Name.compareTo(player2Name) == 1){
            return player1;
        }
        return player2;
    }


    public void initializeGame () {
        Player player1 = new Player(player1Name); /////////////////////////////////////////////
        Player player2 = new Player(player2Name); //////////////////////////////////////
        Player start = startPlayer();



    }


}
