package softuni.jsonexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.jsonexercise.domain.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    //2. Cars from make Toyota - all cars from make Toyota and
    // order them by model alphabetically and then by travelled distance descending.

    @Query(value = "select c from Car c where c.make=:carMake order by c.model asc, c.travelledDistance desc")
    List<Car> allToyotaCarsOrderedByModel(@Param(value = "carMake") String carMake);

    //4.  Cars with Their List of Parts -  all cars along with their list of parts.
    // For the car get only make, model and travelled distance. For the parts get only the name and the price.
    List<Car> findAll();

}
