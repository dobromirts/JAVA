package softuni.cardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.cardealer.domain.entities.Supplier;


import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    List<Supplier> findAllByImportedFalse();
}
