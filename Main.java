import java.util.Random;
import java.util.Scanner;

// Main class: Entry point with mode selection
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" █████    █████   ██████  ");
        System.out.println("██   ██  ██   ██  ██   ██ ");
        System.out.println("██   ██  ██   ██  ██████  ");
        System.out.println("██   ██  ██   ██  ██      ");
        System.out.println(" █████    █████   ██      ");
        System.out.println("=================================");
        System.out.println("  TIC-TAC-TOE: ORDER OF PLAY");
        System.out.println("=================================\n");

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Choose mode:");
        System.out.println("1 - PvP (Player vs Player)");
        System.out.println("2 - PvE (Player vs Entity/AI)");
        int mode = scanner.nextInt();

        Player player1, player2;
        if (mode == 1) {  // PvP
            player1 = new HumanPlayer("Player 1", 'X', scanner);
            player2 = new HumanPlayer("Player 2", 'O', scanner);
        } else {  // PvE
            player1 = new HumanPlayer("Player", 'X', scanner);
            player2 = new AIPlayer("AI", 'O');
        }

        Board board = new Board();
        Consequence[] consequences = {
            new SkipTurnConsequence(),
            new ExtraTurnConsequence(),
            new RandomMoveConsequence()
        };

        board.displayBoard();
        Player currentPlayer = player1;
        Random random = new Random();

        while (true) {
            System.out.println(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");

            // Random consequence every turn
            Consequence consequence = consequences[random.nextInt(consequences.length)];
            if (consequence.apply(board, currentPlayer)) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                }
                if (board.isFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
                continue;
            }

            boolean validMove = false;
            while (!validMove) {
                validMove = currentPlayer.makeMove(board);
            }

            if (board.checkWin(currentPlayer.getSymbol())) {
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        scanner.close();
    }
}
