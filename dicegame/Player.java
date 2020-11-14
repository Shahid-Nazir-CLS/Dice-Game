package dicegame;

public class Player {
    private String playerName;
    private Dice dice1;
    private Dice dice2;

    public Player(){
        playerName = null;
    }

    public int rollDie(){
        dice1 = new Dice();
        dice2 = new Dice();

        return dice1.getDiceFaceValue() + dice2.getDiceFaceValue();
    }

    public void setPlayerName(String name){
        playerName = name;
    }

    public String getPlayerName(){
        return playerName;
    }
}
