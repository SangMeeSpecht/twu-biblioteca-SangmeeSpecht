import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sspecht on 1/15/17.
 */
public class Menu {
    private final BufferedReader bufferedReader;
    private PrintStream printStream;

    public Menu(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void listOptions() {
        String listOfOptions;
        listOfOptions = "Options\n";
        listOfOptions += "1. List Books";


        printStream.println(listOfOptions);
    }

    public String askForOption() throws IOException {
        printStream.println("Enter an option number:");
        String userInput;

        Map<String, Command> commandMap = new HashMap<String, Command>();
        commandMap.put("1", new DisplayBooksCommand());


        while(true) {
            userInput = readUserInput();
            if(commandMap.containsKey(userInput)) {
                Command displayBooksCommand = commandMap.get(userInput);
                displayBooksCommand.execute();
                break;
            } else {
                displayInvalidInput();
            }
        }

        return userInput;
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

