package com.manhattan;

import com.manhattan.models.BookTitleAndPriceModel;
import com.manhattan.models.BookTitleEditionTypeAndPriceModel;
import com.manhattan.services.interfaces.AuthorService;
import com.manhattan.services.interfaces.BookService;
import com.manhattan.services.interfaces.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import static com.manhattan.common.Utilities.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final SeedService seedService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
//        printInfoMessage("Seeding...");
//        this.seedService.seedAll();

        printMenu();
        int problemNumber = readIntFromConsole("Enter problem number:");
        while (problemNumber != 0) {
            switch (problemNumber) {
                case 1 -> executeProblem1();
                case 2 -> executeProblem2();
                case 3 -> executeProblem3();
                case 4 -> executeProblem4();
                case 5 -> executeProblem5();
                case 6 -> executeProblem6();
                case 7 -> executeProblem7();
                case 8 -> executeProblem8();
                default -> printRedMessage("Unexpected value: " + problemNumber);
            }
            printMenu();
            problemNumber = readIntFromConsole("Enter problem number:");
        }
    }

    /**
     * Problem 1.Books Titles by Age Restriction
     * Write a program that prints the titles of all books, for which the age restriction matches
     * the given input (minor, teen or adult). Ignore casing of the input.
     *
     * @throws IOException
     */
    private void executeProblem1() throws IOException {
        String restriction = readStringFromConsole("Enter restriction: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .getBookTitlesAccordingRestriction(restriction)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 2.Golden Books
     * Write a program that prints the titles of the golden edition books, which have less than 5000 copies.
     */
    private void executeProblem2() {
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .findGoldenEditionBooksWithCopiesLessThan(5000)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 3. Books by Price
     * Write a program that prints the titles and prices of books with price lower than 5 and higher than 40.
     */
    private void executeProblem3() {
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .findBooksWithPriceLowerThanAndHerThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .stream()
                .map(BookTitleAndPriceModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 4. Not Released Books
     * Write a program that prints the titles of all books that are NOT released in a given year.
     */
    private void executeProblem4() throws IOException {
        int year = readIntFromConsole("Enter release year: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService
                .findBooksNotReleasedInYear(year)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * problem 5. Books Released Before Date
     * * Write a program that prints the title, the edition type and the price of books,
     * * which are released before a given date. The date will be in the format dd-MM-yyyy.
     *
     * @throws IOException
     */
    private void executeProblem5() throws IOException {
        String strDate = readStringFromConsole("Enter release date in format /dd-MM-yyyy/: ");
        printInfoMessage("Result: ");
        LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(this.bookService
                .findBooksReleasedBefore(date)
                .stream()
                .map(BookTitleEditionTypeAndPriceModel::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 6. Authors Search
     * Write a program that prints the names of those authors, whose first name ends with a given string.
     *
     * @throws IOException
     */
    private void executeProblem6() throws IOException {
        String endName = readStringFromConsole("Enter end of the first name: ");
        printInfoMessage("Result: ");
        System.out.println(this.authorService.getAllAuthorsWithFirstNameEndsWith(endName)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 7. Books Search
     * Write a program that prints the titles of books, which contain a given string (regardless of the casing).
     *
     * @throws IOException
     */
    private void executeProblem7() throws IOException {
        String pattern = readStringFromConsole("Enter pattern: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService.getAllBooksWithTitlesContainsCaseInsensitive(pattern)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 8. Book Titles Search
     * Write a program that prints the titles of books, which are written by authors, whose last name starts with a given string.
     *
     * @throws IOException
     */
    private void executeProblem8() throws IOException {
        String pattern = readStringFromConsole("Enter the start of the Author's last name: ");
        printInfoMessage("Result: ");
        System.out.println(this.bookService.getAllBooksAuthorsLastNameStartsWith(pattern)
                .stream()
                .collect(Collectors.joining(System.lineSeparator())));
    }

    /**
     * Problem 9.	Count Books
     * Write a program that prints the number of books, whose title is longer than a given number.
     *
     * @throws IOException
     */
    private void executeProblem9() throws IOException {
        int limit = readIntFromConsole("Enter title limit: ");
        printInfoMessage("Result: ");
        System.out.printf("There are %d books with longer title than %d symbols",
                this.bookService.getCountOfBooksThatHasTitleLongerThan(limit), limit);
        System.out.println();
    }


    private void printMenu() {
        printInfoMessage("--------------------------------------------------------------------------");
        StringBuilder sb = new StringBuilder()
                .append("Choose problem").append(System.lineSeparator())
                .append("--------------------------------").append(System.lineSeparator())
                .append("1. Books Titles by Age Restriction").append(System.lineSeparator())
                .append("2. Golden Books").append(System.lineSeparator())
                .append("3. Books by Price").append(System.lineSeparator())
                .append("4. Not Released Books").append(System.lineSeparator())
                .append("5. Books Released Before Date").append(System.lineSeparator())
                .append("6. Authors Search").append(System.lineSeparator())
                .append("7. Books Search").append(System.lineSeparator())
                .append("8. Book Titles Search").append(System.lineSeparator())
                .append("9. Count Books").append(System.lineSeparator())
                .append("10. Total Book Copies").append(System.lineSeparator())
                .append("11. Reduced Book").append(System.lineSeparator())
                .append("12. * Increase Book Copies").append(System.lineSeparator())
                .append("13. * Remove Books").append(System.lineSeparator())
                .append("14. * Stored Procedure").append(System.lineSeparator())
                .append("0. exit").append(System.lineSeparator());
        System.out.println(sb);
    }
}
