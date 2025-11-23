import java.util.Random;

abstract interface Consequence {
    boolean apply(Board board, Player player);
}

class SkipTurnConsequence implements Consequence {
    @Override
    public boolean apply(Board board, Player player) {
        System.out.println(player.getName() + " must skip this turn due to consequence!");
        return true;  // Skip their turn
    }
}

class ExtraTurnConsequence implements Consequence {
    @Override
    public boolean apply(Board board, Player player) {
        System.out.println(player.getName() + " gets an EXTRA TURN due to consequence!");
        return false; // They still play right now
    }
}

class RandomMoveConsequence implements Consequence {
    private Random random = new Random();

    @Override
    public boolean apply(Board board, Player player) {
        System.out.println(player.getName() + " has a RANDOM MOVE due to consequence!");

        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!board.isCellEmpty(row, col));

        System.out.println("Random move chosen: (" + (row + 1) + ", " + (col + 1) + ")");
        board.makeMove(row, col, player.getSymbol());
        return false; 
    }
}