package softuni.jsonexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.jsonexercise.domain.entities.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    //1.Ordered Customers - all customers, ordered by their birthdate in ascending order. If two customers are born on the same date,
    // first print those, who are not young drivers (e.g. print experienced drivers first)

    @Query(value = "select c from Customer c order by c.birthDate, c.youngDriver asc")
    List<Customer> orderCustomersByBirthDateAndYoungDriver();

    //5. Total Sales by Customer -all customers that have bought at least 1 car and get their names,
    // count of cars bought and total money spent on cars. Order the result list by total money spent
    // in descending order then by total cars bought again in descending order.

    @Query(value = "select  c from Customer c where  SIZE(c.sales)>0")
    List<Customer>AllCustomersWithSales();
}
