package softuni.jsonexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.jsonexercise.domain.entities.Sale;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    //6. Sales with Applied Discount -Get all sales with information about the car,
    // the customer and the price of the sale with and without discount.
@Query(value="select s from Sale s")
    List<Sale>findAll();

}
