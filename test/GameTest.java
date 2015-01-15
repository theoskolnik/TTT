import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {
    private Game game;
    private PrintStream printStream;
    private Board board;
    private Player player;
    private BufferedReader bufferedReader;


//    Prompt player 1 to enter a number between 1 and 9 to indicate where they wish to move.
// Redraw the board with an ‘X’ in that location. It doesn’t matter what happens if they enter
// anything besides a number from 1 to 9.


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        game = new Game(printStream, board, bufferedReader);
        player = mock(Player.class);
    }

    @Test
    public void shouldPromptPlayerOneToEnterANumberWhenGameStarts() throws IOException {
        game.play();
        verify(printStream).println(board.drawBoard());
        verify(printStream).println("Enter a number 1 through 9");
    }

    @Test
    public void shouldProcessPlayerInputCorrectly() throws IOException {
        game.play();
        when(bufferedReader.readLine()).thenReturn("1");
        assertThat(game.processInput(), is(1));
    }


}