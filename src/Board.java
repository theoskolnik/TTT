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
        for (int i = 0; i < grid.length; i++) {
            if (grid[i].equals("X") || grid[i].equals("O")){
                count++;
            }
        }
        if (count == 9) {
            return true;
        }
        return false;
    }

    public boolean isMoveTaken(Integer move) {
        boolean cell = grid[move - 1].equals("");
        return !cell;
    }
}
