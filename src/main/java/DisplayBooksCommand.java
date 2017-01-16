/**
 * Created by sspecht on 1/16/17.
 */
public class DisplayBooksCommand implements Command {
    private Library library;

    public DisplayBooksCommand(Library library) {

        this.library = library;
    }
    public void execute() {
        library.displayAllBooks();
    }
}
