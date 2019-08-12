package softuni.jsonexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.jsonexercise.domain.entities.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    //3. Categories By Products Count
    @Query(value = "select c.name,count(p.id),sum(p.price) from Category c inner join c.products p group by c.name ")
    List<Object[]> categoryByProductCount();
}
