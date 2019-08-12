package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "D:\\JavaDB Advanced-Hibernate,Spring\\SpringData AvdancedQuery 6\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;
    private Scanner scanner;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
        this.scanner=new Scanner(System.in);
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> getAllByTitleWithAgeRestriction() {
        String ageRestriction=scanner.nextLine().toUpperCase();
        return this.bookRepository.findAllByAgeRestrictionLike(AgeRestriction.valueOf(ageRestriction)).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllByEditionAndCopies() {
        return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD,5000).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public String getAllByPrice() {
        BigDecimal less=new BigDecimal("5");
        BigDecimal greater=new BigDecimal("40");
        List<String> books=this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(less,greater)
                .stream().map(b->String.format("%s - $%.2f",b.getTitle(),b.getPrice())).collect(Collectors.toList());

        return String.join("\r\n",books);
    }

    @Override
    public List<String> getAllTitlesNotInReleasedDate() {
        String year=this.scanner.nextLine();
        LocalDate less=LocalDate.parse(year+"-01-01",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate greater=LocalDate.parse(year+"-12-31",DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return this.bookRepository.findAllByReleaseDateLessThanOrReleaseDateGreaterThan(less,greater).stream()
                .map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBeforeGivenDate() {
        String date=this.scanner.nextLine();
        LocalDate localDate=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return this.bookRepository.findAllByReleaseDateLessThan(localDate).stream()
                .map(b->String.format("%s %s %.2f",b.getTitle(),b.getEditionType().name(),b.getPrice())).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTitlesLike() {
        String pattern="%"+scanner.nextLine()+"%";
        return this.bookRepository.findAllByTitleLike(pattern).stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTitlesByAuthorsLastNamePattern() {
        String pattern=this.scanner.nextLine().toLowerCase()+"%";
        return this.bookRepository.findAllTitlesWhereAutorsNameStartsWith(pattern)
                .stream().map(b->String.format("%s (%s %s)",b.getTitle(),b.getAuthor().getFirstName(),b.getAuthor().getLastName())).collect(Collectors.toList());
    }

    @Override
    public Integer getAllTitleWithGreaterLength() {
        int intput=Integer.parseInt(scanner.nextLine());
        int count=0;

        List<Book> books=this.bookRepository.findBooksWithTitlesOverLenght();
        for (Book book : books) {
            if (book.getTitle().length()>intput){
                count++;
            }
        }

        return count;
    }

    @Override
    public List<String> getAllCopiesByAuthor() {
        return this.bookRepository.findAllBooksByAuthorsAndCopies().stream()
                .map(result->String.format("%s %s - %s",result[0],result[1],result[2])).collect(Collectors.toList());
    }

    @Override
    public String getAllInfoByTitle() {
        String title=this.scanner.nextLine();
        Book book=this.bookRepository.findBookByTitleLike(title);

        return String.format("%s %s %s %.2f",book.getTitle(),book.getEditionType().name(),book.getAgeRestriction().name(),book.getPrice());
    }
}
