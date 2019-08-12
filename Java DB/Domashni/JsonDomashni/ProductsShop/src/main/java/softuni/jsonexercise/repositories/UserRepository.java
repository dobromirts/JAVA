package softuni.jsonexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.jsonexercise.domain.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // 2. Successfully Sold Products
    @Query(value="Select  u from User u inner join  u.soldProducts p where p.buyer is not null " +
            "group by u.id order by u.lastName, u.firstName")
    List<User> findAllWithProductsSold();

    //4. Users and Products - users who have at least 1 product sold. Order them by the number of products
    // sold (from highest to lowest), then by last name (ascending).
    @Query(value="select  distinct u from User u inner join fetch u.soldProducts p where p.buyer is not null")
    List<User> usersWithProducts();

}
