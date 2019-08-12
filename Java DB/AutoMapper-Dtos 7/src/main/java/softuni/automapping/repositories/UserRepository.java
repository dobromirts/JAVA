package softuni.automapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import softuni.automapping.domain.entities.User;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);

}
