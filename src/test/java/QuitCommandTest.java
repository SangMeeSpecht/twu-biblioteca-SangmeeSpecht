import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/16/17.
 */

public class QuitCommandTest {
    private QuitCommand quitCommand;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        quitCommand = new QuitCommand(printStream);
    }

    @Test
    public void shouldDisplayGoodbyeMessageWhenExecuted() {
        quitCommand.execute();
        verify(printStream).println("Goodbye!");
    }
}