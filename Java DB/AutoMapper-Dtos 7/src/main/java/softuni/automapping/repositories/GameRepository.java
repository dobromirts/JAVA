package softuni.automapping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.automapping.domain.entities.Game;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    @Override
    Optional<Game> findById(Integer integer);

    @Override
    List<Game> findAll();

    Optional<Game>findByTitle(String title);
}
