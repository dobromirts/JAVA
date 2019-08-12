package softuni.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.cardealer.domain.entities.Customer;


import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT c FROM Customer as c order by c.birthDate")
    List<Customer> findAllCustomersOrderdByBirthDate();
}
