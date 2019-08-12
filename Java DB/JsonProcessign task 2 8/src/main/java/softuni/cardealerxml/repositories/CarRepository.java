package softuni.cardealerxml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.cardealerxml.domain.entities.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query(value = "SELECT c from Car as c where c.make=:make order by c.model,c.travelledDistance")
    List<Car> findAllByMakeOrderByModel(@Param("make") String make);

    @Query(value = "select c from Car as c")
    List<Car> findAllCars();
}
