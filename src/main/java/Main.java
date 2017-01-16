import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sspecht on 1/11/17.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = new PrintStream(System.out);

        ColumnFormatter columnFormatter = new ColumnFormatter();
        Book bookOne = new Book("Harry Potter", "Jk", "1999", printStream, columnFormatter);
        Book bookTwo = new Book("The Hobbit", "JRR", "1965", printStream, columnFormatter);
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(bookOne);
        bookList.add(bookTwo);

        Library library = new Library(bookList , columnFormatter , printStream);

        Map<String, Command> commandMap = new HashMap<String, Command>();
        commandMap.put("1", new DisplayBooksCommand(library));
        commandMap.put("2", new QuitCommand(printStream));

        Menu menu = new Menu(printStream, bufferedReader, commandMap);

        Welcome welcome = new Welcome(printStream);


        Application application = new Application(welcome, menu);
        application.start();
    }
}
