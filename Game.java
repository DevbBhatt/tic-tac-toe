import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        char[][] board = new char[3][3];

        for(int row=0; row<board.length; row++){
            for(int col=0; col<board[row].length; col++){
                    board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println("Player "+ player +" enter: ");

            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Out of range! Try again.");
            continue;
        }


            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board,player);
                if(gameOver) {
                    System.out.println("Player " + player + " has won");
                }
                 else{
                    gameOver = isBoardFull(board);
                    if(gameOver){
                        System.out.println("Game Drawn");
                        } 
                    else {
                    if(player == 'X') player = 'O';
                    else player = 'X';
                        }
                     }

            } else{
                System.out.println("Invalid move. Try again");
            }
        }
            printBoard(board);
    }

            public static boolean isBoardFull(char[][] board) {
    for (int r = 0; r < board.length; r++)
        for (int c = 0; c < board[r].length; c++)
            if (board[r][c] == ' ') return false;
    return true;
}


    public static boolean haveWon(char[][] board, char player) {
            for(int row=0;row<board.length;row++){
                if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                    return true;
                }
            }

            for(int col =0;col<board.length; col++){
                if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                    return true;
                }
            }

            if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
                return true;
            }

             if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
                return true;
            }

            return false;
    }

   public static void printBoard(char[][] board) {
    for (int r = 0; r < 3; r++) {
        System.out.printf(" %c | %c | %c %n", board[r][0], board[r][1], board[r][2]);
        if (r < 2) System.out.println("---+---+---");
    }
}

}
