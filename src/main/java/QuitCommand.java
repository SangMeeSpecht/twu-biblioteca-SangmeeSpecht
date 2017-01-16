import java.io.PrintStream;

/**
 * Created by sspecht on 1/16/17.
 */

public class QuitCommand implements Command {
    private PrintStream printStream;

    public QuitCommand(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void execute() {
        printStream.println("Goodbye!");
    }
}
