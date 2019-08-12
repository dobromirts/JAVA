package bookshopsystemapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> getAllByTitleWithAgeRestriction();

    List<String> getAllByEditionAndCopies();

    String getAllByPrice();

    List<String> getAllTitlesNotInReleasedDate();

    List<String> getAllBeforeGivenDate();

    List<String> getAllTitlesLike();

    List<String> getAllTitlesByAuthorsLastNamePattern();

    Integer getAllTitleWithGreaterLength();

    List<String> getAllCopiesByAuthor();

    String getAllInfoByTitle();
}
