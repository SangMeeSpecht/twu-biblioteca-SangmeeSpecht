import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by sspecht on 1/15/17.
 */
public class MenuTest {
    private Menu menu;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map<String, Command> commandMap;
    private DisplayBooksCommand displayBooksCommand;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        displayBooksCommand = mock(DisplayBooksCommand.class);
        commandMap = new HashMap<String, Command>();
        commandMap.put("1", displayBooksCommand);

        menu = new Menu(printStream, bufferedReader, commandMap);
    }

    @Test
    public void shouldListOptions() {
        menu.listOptions();
        verify(printStream).println("Options\n1. List Books");
    }

//    failed
    @Test
    public void shouldDisplayMessageAskingForOptionNumber() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.askForOption();
        verify(printStream).println("Enter an option number:");
    }

//    failed
    @Test
    public void shouldGetUsersMenuChoiceWhenUserEntersOptionNumber() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");
        menu.askForOption();
        assertThat(menu.askForOption(), is("1"));

    }

    @Test
    public void shouldDisplayInvalidInputWhenUserSelectsAnOptionNotOnTheMenu() throws IOException {
        menu.displayInvalidInput();

        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldReturnFalseWhenUserEntersInvalidInput() throws IOException {
        Boolean userInput = menu.isValidInput("INVALID");

        assertThat(userInput, is(false));
    }

    @Test
    public void shouldReturnTrueWhenUserEntersValidInput() throws IOException {
        Boolean userInput = menu.isValidInput("1");

        assertThat(userInput, is(true));
    }

//    failed
    @Test
    public void shouldAskUserForInputAgainIfInvalidInputEntered() throws IOException {
        when(bufferedReader.readLine()).thenReturn("INVALID","1");
        menu.askForOption();
        verify(bufferedReader,times(2)).readLine();
    }

}