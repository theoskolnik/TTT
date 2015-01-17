import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BoardTest {
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldPrintBoardGrid() {
        board.print();
        verify(printStream, times(3)).printf("%3s|%3s|%3s\n", "", "", "");
        verify(printStream, times(2)).println("-----------");
    }

//    @Test
//    public void shouldUpdateBoardWithAnX() throws IOException {
//        String formattedBoardString = "X |  |   \n---------\n  |  |   \n---------\n  |  |  ";
//        when(app.processInput()).thenReturn(1);
//        app.start();
//        app.processInput();
//        assertThat(board.updateBoard(), is(formattedBoardString));
//    }

}