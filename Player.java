import java.util.Random;
import java.util.Scanner;

abstract interface Player {
    boolean makeMove(Board board);
    char getSymbol();
    String getName();
}

class HumanPlayer implements Player {
    private String name;
    private char symbol;
    private Scanner scanner;

    public HumanPlayer(String name, char symbol, Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.scanner = scanner;
    }

    @Override
    public boolean makeMove(Board board) {
        System.out.print("Enter row (1-3): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter column (1-3): ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid input! Try again.");
            return false;
        }

        if (!board.isCellEmpty(row, col)) {
            System.out.println("Cell already taken! Try again.");
            return false;
        }

        return board.makeMove(row, col, symbol);
    }

    @Override
    public char getSymbol() { return symbol; }

    @Override
    public String getName() { return name; }
}

class AIPlayer implements Player {
    private String name;
    private char symbol;
    private Random random = new Random();

    public AIPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public boolean makeMove(Board board) {
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.isCellEmpty(row, col));

        System.out.println("\nAI chooses (" + (row + 1) + ", " + (col + 1) + ")");
        return board.makeMove(row, col, symbol);
    }

    @Override
    public char getSymbol() { return symbol; }

    @Override
    public String getName() { return name; }
}
