import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sspecht on 1/12/17.
 */
public class ApplicationTest {
    private Menu menu;
    private Application application;
    private Welcome welcome;

    @Before

    public void setUp()
    {
        menu = mock(Menu.class);
        welcome = mock(Welcome.class);
        application = new Application(welcome, menu);
    }

    @Test
    public void shouldCallWelcomeMessage() throws IOException {

        application.start();
        verify(welcome).displayWelcomeMessage();

    }

    @Test
    public void shouldDisplayListOfOptionsWhenStartIsCalled() throws IOException {
        application.start();
        verify(menu).listOptions();
    }

    @Test
    public void shouldAskUserForMenuNumberWhenStartIsCalled() throws Exception {
        application.start();
        verify(menu).askForOption();
    }
}