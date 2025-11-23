class Board {
    private char[][] grid = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    // Draw the board with borders
    public void displayBoard() {
        System.out.println("\n  +---+---+---+");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + grid[i][j] + " |");
            }
            System.out.println("\n  +---+---+---+");
        }
        System.out.println("    1   2   3\n");
    }

    public boolean makeMove(int row, int col, char symbol) {
        if (isCellEmpty(row, col)) {
            grid[row][col] = symbol;
            System.out.println("\nPlaced '" + symbol + "' at (" + (row + 1) + ", " + (col + 1) + ")");
            displayBoard();
            return true;
        }
        return false;
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col] == ' ';
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
            if (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
               (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j] == ' ') return false;
        return true;
    }
}
    

