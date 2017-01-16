import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

/**
 * Created by sspecht on 1/15/17.
 */

public class Menu {
    private final BufferedReader bufferedReader;
    private Map<String, Command> commandMap;
    private PrintStream printStream;
    private Boolean active = true;

    public Menu(PrintStream printStream, BufferedReader bufferedReader, Map<String, Command> commandMap) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.commandMap = commandMap;
    }

    public void listOptions() {
        String optionOne = "1. List Books";
        String optionTwo = "2. Quit";
        String listOfOptions = String.format("Options\n%s\n%s", optionOne, optionTwo);

        printStream.println(listOfOptions);
    }

    public void askForOption() throws IOException {
        String userInput;

        while(active) {
            printStream.println("Enter an option number:");
            userInput = readUserInput();

            if(isAValidInput(userInput)) {
                Command command = commandMap.get(userInput);
                command.execute();

                if(isInputToQuit(userInput)) {
                    break;
                }

            } else {
                displayInvalidInput();
            }
        }
    }

    private boolean isInputToQuit(String userInput) {
        return userInput.equals("2");
    }

    private boolean isAValidInput(String userInput) {
        return commandMap.containsKey(userInput);
    }

    private String readUserInput() throws IOException {
        return bufferedReader.readLine();
    }

    public void displayInvalidInput() throws IOException {
        printStream.println("Select a valid option!");
    }
}

