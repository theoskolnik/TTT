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

public class ApplicationTest {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Application app;
    private Game game;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        game = mock(Game.class);
        app = new Application(printStream, bufferedReader, game);
    }

    @Test
    public void shouldPrintBoardAndPromptWhenAppStarts() throws IOException {
        app.start();
        when(board.drawBoard()).thenReturn("board string");
        verify(printStream).println(game.returnBoard());
        verify(printStream).println("Enter a number 1 through 9");
    }

    @Test
    public void shouldPrintBoard() {
        when(game.returnBoard()).thenReturn("board string");
        app.printBoard();
        verify(printStream).println("board string");
    }

    @Test
    public void shouldPromptPlayerOneToEnterANumber() throws IOException {
        app.promptPlayerToMove();
        verify(printStream).println("Enter a number 1 through 9");
    }

    @Test
    public void shouldProcessPlayerInputCorrectly() throws IOException {
        app.start();
        when(bufferedReader.readLine()).thenReturn("1");
        assertThat(app.processInput(), is(1));
    }



}