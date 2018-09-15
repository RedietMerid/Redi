
package connect4;

import java.util.Random;
import java.util.Scanner;

/**
 * A Connect4 Game code
 * @author Rediet Merid
 * @version 1.0 Build Aug, 2018 
 */

public class Connect4TextConsole {
    
    /**
     * This are a final variables means can not be changed ons the are created. if changes our board size increases.
     * global variables
     */
    final static int WIDTH = 7;
    final static int HEIGHT = 8;
    final static int LAST_ROW = WIDTH - 1;

    //game board
    static char[][] board = new char[WIDTH][HEIGHT];

    //creates scanner
    static Scanner scanner = new Scanner(System.in);
/**we are creating the board on the size given above*/
    public static void CreateBoard() {
        //fills board with '.' for the width and height
        for (int w = 1; WIDTH > w; w += 1) {
            for (int h = 1; HEIGHT > h; h += 1) {
                board[w][h] = '|';
            }
        }
    }
   
/**Printing the board */
    public static void PrintBoard() {
        //prints the board
        for (int w = 1; WIDTH > w; w += 1) {
            for (int h = 1; HEIGHT > h; h += 1) {
                System.out.print(board[w][h]);
            }
            System.out.println();
        }
        System.out.println();
                
               
    }
/**Player X*/
    public static void PlayerX(){
        //creates a counter
        int counter = 1;

        //shows who's turn it is turn
        System.out.println("PlayerX - your turn.Choose a column number from 1-7.");

        //gets input
       int column = scanner.nextInt();
        
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

/**Player 0*/
    public static void Player0(){
        //creates a counter
        int counter = 1;

        //shows whos turn
        System.out.println("Player0 - your turn.Choose a column number from 1-7.");

        //gets input
        int column = scanner.nextInt();

        while(true){
            if(column > WIDTH){
                System.out.println("Invalid column Input.");
                break;
            }

            if (board[LAST_ROW][column] == '|') { //checks to see if space is blank, puts O there if it is
                board[LAST_ROW][column] = 'O';
                break; //breaks loop after placing
            }else if(board[LAST_ROW][column] == 'X' || board[LAST_ROW][column] == 'O'){ //if space isn't blank, checks to see if one above is
                if(board[LAST_ROW - counter][column] == '|'){ //puts O if blank
                    board[LAST_ROW - counter][column] = 'O';
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
    
/**Check if 4 x's are connected Horizontally
     * @return flag*/
    public static boolean CheckingXHorizontally(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board horizontally
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'X'){ //if it finds an X, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an X, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player X won the Game."); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }
    
/**Check if 4  x's are connected Verticall
     * @return flag*/
    public static boolean CheckingXVertically(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board vertically
            for(int h = 0; HEIGHT > h; h += 1){
                for(int w = 0; WIDTH > w; w += 1){
                    if(board[w][h] == 'X'){ //if it finds an X, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an X, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player X won the Game."); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }
    
/**Check if 4 x's are connected Forward Diagonally
     * @return flag*/    
    public static boolean CheckingXForwardDiagonally(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ //goes through until an X is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'X'){ //if X is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Xs
                            if(checkColumn + w <= WIDTH - 1&& checkRow + h <= HEIGHT - 1){
                                if(board[w + checkColumn][h + checkRow] == 'X'){ //if X is found, add 1 to counter
                                    counter += 1;
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == WIDTH -1 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player X won the Game."); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }
    
/**Check if 4 x's are connected Back Diagona
     * @return flag*/
    public static boolean CheckingXBackDiagonally(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ //goes through until an X is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'X'){ //if X is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Xs
                            if(w - checkColumn >= 0 && h - checkRow >= 0){
                                if(board[w - checkColumn][h - checkRow] == 'X'){
                                    counter += 1; //if X is found, add 1 to counter
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == 0 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player X won the Game."); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }
    
/**@return Check x's*/
    public static boolean CheckX(){
        //creates flag
        boolean flag = true;

        //checks all Xs at once, for clearner main loop
        if(!CheckingXVertically() || !CheckingXHorizontally()|| !CheckingXBackDiagonally()|| !CheckingXForwardDiagonally()){
            flag = false;
        }
        return flag;
    }
    
/**Check if 4  0's are connected Verticall
     * @return flag*/
    public static boolean Checking0Vertically(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board vertically
            for(int h = 0; HEIGHT > h; h += 1){
                for(int w = 0; WIDTH > w; w += 1){
                    if(board[w][h] == 'O'){ //if it finds an O, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an O, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player 0 won the Game."); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }
    
/**Check if 4 0's are connected Horizontally
     * @return flag*/
    public static boolean Checking0Horizontally(){
        //creates boolean to act as flag
        boolean flag = true;

        //creates counter
        int counter = 0;
        while(flag){

            //goes through board vertically
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'O'){ //if it finds an O, add 1 to counter
                        counter += 1;
                    }else{
                        counter = 0; // if next piece is not an O, set counter to 0
                    }
                    if(counter >= 4){
                        System.out.println("Player 0 won the Game."); //if counter is greater or equal to 4, player wins
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }
    
/**Check if 4  0's are connected Forward Diagonal
     * @return flag*/
    public static boolean Checking0ForwardDiagonally(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ //goes through until an O is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'O'){ //if O is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Os
                            if(checkColumn + w <= WIDTH - 1&& checkRow + h <= HEIGHT - 1){
                                if(board[w + checkColumn][h + checkRow] == 'O'){ //if O is found, add 1 to counter
                                    counter += 1;
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == WIDTH -1 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player 0 won the Game"); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }
    
/**Check if 4  0's are connected Back Diagonal
     * @return flag*/
    public static boolean Checking0BackDiagonally(){
        //flag
        boolean flag = true;

        //counter
        int counter = 0;

        //check boolean
        Boolean check = false;

        //checkers
        int checkColumn = 1;
        int checkRow = 1;

        while(flag){

            //goes through until an O is found
            for(int w = 0; WIDTH > w; w += 1){
                for(int h = 0; HEIGHT > h; h += 1){
                    if(board[w][h] == 'O'){ //if O is found, add one to counter and go into loop
                        counter += 1;
                        check = true;
                        while(check){ //goes through diagonally looking for Os
                            if(w - checkColumn >= 0 && h - checkRow >= 0){
                                if(board[w - checkColumn][h - checkRow] == 'O'){
                                    counter += 1; //if O is found, add 1 to counter
                                }
                            }

                            //adds 1 to checkers
                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == 0 || checkRow == HEIGHT -1){ //if outside of board, break
                                check = false;
                                break;
                            }

                            if(counter >= 4){
                                System.out.println("Player 0 won the Game."); //if counter is greater or equal to 4, player wins
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    //resets counter and checkers
                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }
    
/**@return Check 0's */
    public static boolean CheckO(){
        //creates flag
        boolean flag = true;

        //checks all Os at once, for clearner main loop
        if(!Checking0Vertically() || !Checking0Horizontally() || !Checking0BackDiagonally() || !Checking0ForwardDiagonally()){
            flag = false;
        }
        return flag;
    }


}
    