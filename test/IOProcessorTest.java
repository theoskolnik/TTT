import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IOProcessorTest {

    private BufferedReader in;
    private IOProcessor ioProcessor;

    @Before
    public void setUp() throws Exception {
        in = mock(BufferedReader.class);
        ioProcessor = new IOProcessor(in);
    }

    @Test
    public void shouldProcessPlayerInputCorrectly() throws IOException {
        when(in.readLine()).thenReturn("1");
        Integer input = 1;
        assertEquals(input, ioProcessor.processInput());
    }

}