package softuni.jsonexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.jsonexercise.domain.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    //1.  Products In Range -all products in a specified price range (e.g. 500 to 1000),
    // which have no buyer. Order them by price (from lowest to highest)
    List<Product> findAllByPriceGreaterThanAndPriceLessThanAndBuyerIsNullOrderByPriceAsc(BigDecimal minPrice, BigDecimal maxPrice);

    //2.  -->in UserRepository

    //3. -->in CategoryRepository

    //4. -->in UserRepository
}
