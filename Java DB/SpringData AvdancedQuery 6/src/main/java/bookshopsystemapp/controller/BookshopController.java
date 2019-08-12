package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.authorService.seedAuthors();
//        this.categoryService.seedCategories();
//        this.bookService.seedBooks();


        /*
        Task 1
         */
        //this.printBookTitlesByAgeRestriction();

        /*
        Task 2
         */
        //this.printGoldenBooks();

        /*
        Task 3
         */
        //this.booksByPrice();

        /*
        Task 4
         */
        //this.notReleasedBooks();

        /*
        Task 5
         */
        //this.booksReleasedBeforeDate();

        /*
        Task 6
         */
        //this.authorsSearch();

        /*
        Task 7
         */
        //this.booksSearch();

        /*
        Task 8
         */
        //this.booksTitleSearch();

        /*
        Task 9
         */
        //this.countBooks();

        /*
        Task 10
         */
        //this.totalBooksCopies();

        /*
        Task 11
         */
        this.reducedBook();
    }

    private void reducedBook() {
        System.out.println(this.bookService.getAllInfoByTitle());
    }

    private void totalBooksCopies() {
        this.bookService.getAllCopiesByAuthor().forEach(System.out::println);
    }

    private void countBooks() {
        System.out.println(this.bookService.getAllTitleWithGreaterLength());
    }

    private void booksTitleSearch() {
        this.bookService.getAllTitlesByAuthorsLastNamePattern().forEach(System.out::println);
    }

    private void booksSearch() {
        this.bookService.getAllTitlesLike().forEach(System.out::println);
    }

    private void authorsSearch() {
        this.authorService.getAllNamesEndingWith().forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() {
        this.bookService.getAllBeforeGivenDate().forEach(System.out::println);
    }

    private void notReleasedBooks() {
        this.bookService.getAllTitlesNotInReleasedDate().forEach(System.out::println);
    }

    private void booksByPrice() {
        System.out.println(this.bookService.getAllByPrice());
    }

    private void printGoldenBooks() {
        this.bookService.getAllByEditionAndCopies().forEach(System.out::println);
    }

    private void printBookTitlesByAgeRestriction() {
        this.bookService.getAllByTitleWithAgeRestriction().forEach(System.out::println);
    }
}
