/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import static connect4.Connect4TextConsole.LAST_ROW;
import static connect4.Connect4TextConsole.WIDTH;
import static connect4.Connect4TextConsole.board;
import java.util.Random;

/**
 *
 * @author rediet
 */
public class Connect4ComputerPlayer {
    /**Computer Player*/
    public static void ComputerPlayer(){
        //creates a counter
        int counter = 1;

        //shows who's turn it is turn
        System.out.println("Computer - your turn.Choose a column number from 1-7.");

            //gets input
        /** use random method to let the computer choose randomly*/
        Random rand = new Random();
        int computerMove = rand.nextInt(6) + 1;
        int column = computerMove;

        while(true){
            if(column > WIDTH){
                System.out.println("Invalid column Input.");
                break;
            }

            if (board[LAST_ROW][column] == '|') { //checks to see if space is blank, puts X there if it is
                board[LAST_ROW][column] = 'X';
                break; //breaks loop after placing
            }else if(board[LAST_ROW][column] == 'X' || board[LAST_ROW][column] == 'O'){ //if space isn't blank, checks to see if one above is
                if(board[LAST_ROW - counter][column] == '|'){ //puts X if blank
                    board[LAST_ROW - counter][column] = 'X';
                    break; //breaks loop after placing
                }
            }
            counter += 1; //adds one to counter if the space wasn't blank, then loops again
            if(counter == WIDTH){ //checks to see if at end of column
                System.out.println("This column is full.");
                break;
            }
        }
    }
}
