package softuni.cardealerxml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardealerxml.domain.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
