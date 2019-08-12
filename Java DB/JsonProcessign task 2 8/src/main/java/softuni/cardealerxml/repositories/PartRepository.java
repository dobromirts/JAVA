package softuni.cardealerxml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardealerxml.domain.entities.Part;

@Repository
public interface PartRepository extends JpaRepository<Part,Integer> {
}
