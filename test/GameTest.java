import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class GameTest {

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
    }

    @Test
    public void shouldReturnTrueIfAllBoardSpacesAreTaken() {

    }

}