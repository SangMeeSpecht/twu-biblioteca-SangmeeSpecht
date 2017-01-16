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
        printStream.println("Enter an option number:");
        String userInput;

        while(active) {
            userInput = readUserInput();

            if(commandMap.containsKey(userInput)) {
                Command command = commandMap.get(userInput);
                command.execute();

                if(userInput == "2") {
                    break;
                }

            } else {
                displayInvalidInput();
            }
        }
    }

    private String readUserInput() throws IOException {
        return bufferedReader.readLine();
    }

    public void displayInvalidInput() throws IOException {
        printStream.println("Select a valid option!");
    }

    public Boolean isValidInput(String userInput) throws IOException {
        if(userInput == "1") {
            return true;
        }
        return false;
    }
}

