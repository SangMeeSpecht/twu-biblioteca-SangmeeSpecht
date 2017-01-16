/**
 * Created by sspecht on 1/16/17.
 */
public class CheckoutCommand implements Command {
    private Library library;

    public CheckoutCommand(Library library) {
        this.library = library;
    }

    public void execute() {
        // ask for book title
        // checkout the book; remove it from the booklist
    }
}
