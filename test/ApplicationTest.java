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

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        game = mock(Game.class);
        app = new Application(printStream, bufferedReader, game);
    }

    @Test
    public void shouldPromptPlayerOneToEnterANumber() throws IOException {
        app.promptPlayerToMove();
        verify(printStream).println("Enter a number 1 through 9");
    }

    @Test
    public void shouldProcessPlayerInputCorrectly() throws IOException {
        game.play();
        when(bufferedReader.readLine()).thenReturn("1");
        assertThat(game.processInput(), is(1));
    }


}