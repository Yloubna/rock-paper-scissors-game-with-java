import java.util.Scanner;
import java.util.Random;

/**********************************************

**********************************************/

public class Program {
    /*
        Valid user input: 
        rock, paper, scissors
    */
    public static void main(String[] args) {
        
            try {
                Scanner sc = 
                new Scanner(System.in);
                
                String userInput =   
                sc.next();                      
                if (isValid( userInput )) {
                    game( userInput );
                    
                } else {
                   print("Invalid user input!\nWrite rock, paper or scissors!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
    public static void print(String text) {
       System.out.println( text );
    }
    
    public static boolean isValid(String input) {
        
        if (input.equalsIgnoreCase("rock")) {
           return true; 
        } 
        
        if (input.equalsIgnoreCase("paper")) {
           return true; 
        }
        
         if (input.equalsIgnoreCase("scissors")) {                             
             return true; 
         }
        
        return false;
    }
    
    public static void game(String user) {
        String computer = computerResults();
        
        print( user + " vs " + computer + "\n");
        
        if (user.equalsIgnoreCase(computer)) {
            print("Stalemate! No winners.");
        } else {
        
            if (checkWin(user, computer)) {
               print("You won against the computer!");
            } else {
               print("You lost against the computer!");
            }
        }
    }
    
    public static String computerResults() {
        
        String types[] = 
        {"rock", "paper", "scissors"};
        
        Random rand = new Random(); 
        int computerChoice = rand.nextInt(3);;
        
        return types[computerChoice];
    }
    
    public static boolean checkWin(String user, String opponent) {
        
        if ( (!isValid( user )) && (!isValid( opponent )) ) {
            return false;
        }
        
        String rock = "rock", paper = "paper", scissors = "scissors";
        
        if ( (user.equalsIgnoreCase( rock )) && (opponent.equalsIgnoreCase( scissors )) ) {
           return true; 
        }
        
         if ( (user.equalsIgnoreCase( scissors)) && (opponent.equalsIgnoreCase( paper )) ) {
           return true; 
        }
        
         if ( (user.equalsIgnoreCase( paper )) && (opponent.equalsIgnoreCase( rock  )) ) {
           return true; 
        }
        
        return false; 
        //If no possible win, assume loss.
    }
}
