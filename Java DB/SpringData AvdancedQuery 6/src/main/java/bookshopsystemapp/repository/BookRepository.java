package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestrictionLike(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType,Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal less,BigDecimal greater);

    List<Book> findAllByReleaseDateLessThanOrReleaseDateGreaterThan(LocalDate less,LocalDate greater);

    List<Book> findAllByReleaseDateLessThan(LocalDate localDate);

    List<Book> findAllByTitleLike(String pattern);


    @Query(value = "SELECT b from books b JOIN b.author as a where a.lastName like :pattern")
    List<Book> findAllTitlesWhereAutorsNameStartsWith(@Param(value ="pattern")String pattern);


    @Query(value = "SELECT b from books b")
    List<Book> findBooksWithTitlesOverLenght();


    @Query(value = "SELECT a.firstName,a.lastName,sum(b.copies) as cop from books b inner join b.author as a group by a.firstName order by cop desc")
    List<Object[]> findAllBooksByAuthorsAndCopies();

    Book findBookByTitleLike(String title);


}
