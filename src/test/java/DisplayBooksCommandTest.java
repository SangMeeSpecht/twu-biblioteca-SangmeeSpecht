import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/16/17.
 */
public class DisplayBooksCommandTest {
    private DisplayBooksCommand displayBooksCommand;
    private Library library;

    @Before
    public void setUp() {
        library = mock(Library.class);
        displayBooksCommand = new DisplayBooksCommand(library);
    }

    @Test
    public void shouldDisplayAListOfAllBooksWhenCommandIsExecuted() {
        displayBooksCommand.execute();

        verify(library).displayAllBooks();
    }
}