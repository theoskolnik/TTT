import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class BoardTest {
    private PrintStream printStream;
    private Board board;
    private Player player;
    private BufferedReader bufferedReader;
    private IOProcessor ioProcessor;
    private String[] grid;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        ioProcessor = mock(IOProcessor.class);
        player = mock(Player.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldPrintBoardGrid() {
        board.print();
        verify(printStream, times(3)).printf("%3s|%3s|%3s\n", "", "", "");
        verify(printStream, times(2)).println("-----------");
    }

    @Test
    public void shouldBeFalseIfTheCellIsAlreadyTaken() throws IOException {
        board.updateGrid(2, "X");
        Assert.assertEquals(board.isMoveTaken(2), true);
    }

    @Test
    public void shouldBeTrueIfTheCellIsNotTaken() throws IOException {
        board.updateGrid(1, "X");
        Assert.assertEquals(board.isMoveTaken(2), false);
    }

//    @Test
//    public void shouldCheckIfMoveIsValidBeforeUpdatingTheGrid() throws IOException {
//        Board board = mock(Board.class);
//        when(ioProcessor.getUserInput()).thenReturn(1);
//        player.move();
//        verify(board, times(1)).isMoveTaken(1);
//
//    }



}