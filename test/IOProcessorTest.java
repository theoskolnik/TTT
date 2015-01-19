import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IOProcessorTest {

    private BufferedReader in;
    private IOProcessor ioProcessor;
    private PrintStream printStream;
    private Board board;
    private Player player;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        in = mock(BufferedReader.class);
        board = mock(Board.class);
        player = mock(Player.class);
        ioProcessor = new IOProcessor(in, printStream);
    }

    @Test
    public void shouldChooseCell1WhenUserEnters1() throws IOException {
        when(in.readLine()).thenReturn("1");
        int input = 1;
        assertEquals(input, ioProcessor.getUserInput());
    }

    @Test
    public void shouldChooseCell2WhenUserEnters2() throws IOException {
        when(in.readLine()).thenReturn("2");
        int userInput = ioProcessor.getUserInput();
        assertEquals(2, userInput);
    }

    @Test
    public void shouldPromptPlayerForInput() throws IOException {
        when(in.readLine()).thenReturn("2");
        ioProcessor.getUserInput();
        verify(printStream).println("Enter a number 1 through 9");
    }


}