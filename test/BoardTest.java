import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private BufferedReader in;
    private IOProcessor ioProcessor;
    private Player player;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
        in = mock(BufferedReader.class);
        ioProcessor = new IOProcessor(in);
        player = mock(Player.class);
    }

    @Test
    public void shouldPrintBoardGrid() {
        board.print();
        verify(printStream, times(3)).printf("%3s|%3s|%3s\n", "", "", "");
        verify(printStream, times(2)).println("-----------");
    }

    @Test
    public void shouldUpdateBoardWithAnX() throws IOException {
        when(in.readLine()).thenReturn("1");
        player.getMove();
        board.print();
        verify(printStream, times(1)).printf("%3s|%3s|%3s\n", "X", "", "");
        verify(printStream, times(2)).printf("%3s|%3s|%3s\n", "", "", "");
        verify(printStream, times(2)).println("-----------");
    }

}