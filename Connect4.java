/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import static connect4.Connect4ComputerPlayer.ComputerPlayer;
import static connect4.Connect4TextConsole.CheckO;
import static connect4.Connect4TextConsole.CheckX;
import static connect4.Connect4TextConsole.CreateBoard;
import static connect4.Connect4TextConsole.PrintBoard;
import static connect4.Connect4TextConsole.Player0;
import static connect4.Connect4TextConsole.PlayerX;
import java.util.Scanner;
import static javafx.application.Application.launch;

/**
 *
 * @author rediet
 */
public class Connect4 {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        //creates boolean to determine status of game
        boolean flag = true;
        //creates board
        CreateBoard();
        Scanner input = new Scanner(System.in);
        //how to play game
        System.out.println("Begin Game.");
        System.out.println("Enter ‘U’ if you want to play in the UI version;Enter ‘G’ to play GUI version.");
         String Ans = input.next();
         if(null != Ans)switch (Ans) {
    case "U":                
        System.out.println(" you have entered the UI version of Connect 4");
        System.out.println("Enter ‘P’ if you want to play against another player;Enter ‘C’ to play against computer.");
        String Ans2 = input.next();
        if(null != Ans2)switch (Ans2) {
            case "P":
                System.out.println("Start game against a Friend");
                //displays board
        PrintBoard();
                while(flag){
            //activates player 1s turn, then prints board
            PlayerX();
            PrintBoard();

            //determines if player 1 has won
            if(!CheckX()){
                flag = false; //sets flag to false so loop is not repeated if player 1 won
                break; //break to skip player 2s turn if won
            }

            //activates player 2s turn, then prints board
            Player0();
            PrintBoard();

            //determines if player 1 has won
            if(!CheckO()){
                flag = false; //sets flag to false so loop is not repeated if player 2 won
                break; // break for consistency
            }
        }
                break;
            case "C":
                System.out.println("Start game against computer");
                //displays board
            PrintBoard();
                while(flag){
            //activates computer player's turn, then prints board
            ComputerPlayer();
            PrintBoard();

            //determines if player 1 has won
            if(!CheckX()){
                flag = false; //sets flag to false so loop is not repeated if player 1 won
                break; //break to skip player 2s turn if won
            }

            //activates player 2s turn, then prints board
            Player0();
            PrintBoard();

            //determines if player 1 has won
            if(!CheckO()){
                flag = false; //sets flag to false so loop is not repeated if player 2 won
                break; // break for consistency
            }
        }
                break;  
                    default:
         System.out.println("Invalid input");
         break;
                }
         

      break;
    case "G":

    launch(args);
  
        break;
        
    default:
        System.out.println("Invalid input");

         break;
                }
        }
}

    
                
        
       

    
    
