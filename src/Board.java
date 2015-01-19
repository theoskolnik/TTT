import java.io.PrintStream;

/**
 * Created by tskolnik on 1/15/15.
 */
public class Board {
    private String[] grid;
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        this.grid = new String[] {"", "", "", "", "", "", "", "", ""};
    }

    public void print() {
        printStream.printf("%3s|%3s|%3s\n", grid[0], grid[1], grid[2]);
        printStream.println("-----------");
        printStream.printf("%3s|%3s|%3s\n", grid[3], grid[4], grid[5]);
        printStream.println("-----------");
        printStream.printf("%3s|%3s|%3s\n", grid[6], grid[7], grid[8]);
    }

    public void updateGrid(Integer move, String symbol) {
        if(!isMoveTaken(move)) {
            grid[move - 1] = symbol;
        }
    }


    public boolean allSpacesTaken() {
        int count = 0;
        for (String aGrid : grid) {
            if (aGrid.equals("X") || aGrid.equals("O")) {
                count++;
            }
        }
        return count == 9;
    }

    public boolean isMoveTaken(Integer move) {
        boolean cell = grid[move - 1].equals("");
        return !cell;
    }
}
