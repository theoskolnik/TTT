import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private PrintStream printStream;
    private Game game;
    private Board board;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        bufferedReader = mock(BufferedReader.class);
        game = new Game(printStream, bufferedReader, board);
    }

    @Test
    public void shouldPrintBoardWhenAppStarts() {
        when(board.print()).thenReturn("board string");
        game.start();
        verify(printStream).println("board string");
    }

//    @Test
//    public void shouldPromptPlayerOneToEnterANumber() throws IOException {
//        app.promptPlayerToMove();
//        verify(printStream).println("Enter a number 1 through 9");
//    }
//
//    @Test
//    public void shouldProcessPlayerInputCorrectly() throws IOException {
//        app.start();
//        when(bufferedReader.readLine()).thenReturn("1");
//        assertThat(app.processInput(), is(1));
//    }



}