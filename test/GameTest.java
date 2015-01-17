import org.junit.Before;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;

public class GameTest {

    private PrintStream printStream;
    private Game game;
    private Board board;
    private IOProcessor ioProcessor;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        ioProcessor = mock(IOProcessor.class);
        game = new Game(ioProcessor, board);
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