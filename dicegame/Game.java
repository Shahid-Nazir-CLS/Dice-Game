package dicegame;

import java.util.Scanner;

public class Game {
    private int player1Wins;
    private int totalGames;
    private Player p1;
    private Player p2;
    private String userInput;
    private Scanner scan;


    public Game(){
        player1Wins = 0;
        totalGames = 0;
        p1 = new Player();
        p2 = new Player();
        scan = new Scanner(System.in);
    }

    public void start(){

        while(true){

            System.out.println("\nSelect an option :\n1. Play Game\n2. Display Stats\n3. Exit Game\n");
            int val = scan.nextInt();

            switch(val) {
                case 1:
                    playGame();
                    break;

                case 2:
                    printStats();
                    break;

                case 3:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong Value. Try Again.\n");
            }
        }

    }

    public void playGame(){

        if(p1.getPlayerName() == null && p2.getPlayerName() == null){

            // get and set 1st player name
            System.out.println("First player, enter your name : \n");
            String name1 = scan.next();
            p1.setPlayerName(name1);

            // get and set 2nd player name
            System.out.println("Second player, enter your name : \n");
            String name2 = scan.next();
            p2.setPlayerName(name2);
        }

        System.out.println("Game has started \n ");

        while(true){

            System.out.println(p1.getPlayerName() + " press any key to roll the die");
            userInput = scan.next();

            while(userInput == null){
                userInput = scan.next();
            }  // stay here until player doesn't press a key

            int player1DieValue =  p1.rollDie();
            System.out.println("Your Die sum is " + player1DieValue);

            if(player1DieValue > 7){

                System.out.println(p1.getPlayerName() + " won!\n");
                player1Wins ++;
                totalGames ++;
                return;

            }

            System.out.println(p2.getPlayerName() + " press any key to roll the die");
            userInput = scan.next();


            while(userInput == null){
                userInput = scan.next();
            } // stay here until player doesn't press a key

            int player2DieValue =  p2.rollDie();
            System.out.println("Your Die sum is " + player2DieValue);

            if(player2DieValue > 7){

                System.out.println(p2.getPlayerName() + " won!");
                totalGames ++;
                return;
            }


        }

    }

    public void printStats(){
        if(totalGames == 0){
            System.out.println("\nNo games played yet\n Try playing a game\n");
            return;
        }else{
            System.out.println("The results are as follows : \n\t\t" + p1.getPlayerName()
                    + "\t\t" + p2.getPlayerName() + "\nWins\t\t" + player1Wins + "\t\t" + (totalGames - player1Wins) +
                    "\nTotal Games = " + totalGames);
        }
    }
}
