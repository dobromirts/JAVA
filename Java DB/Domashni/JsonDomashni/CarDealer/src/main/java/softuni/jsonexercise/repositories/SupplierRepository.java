package softuni.jsonexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.jsonexercise.domain.entities.Supplier;

import java.util.List;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    //3. Local Suppliers- all suppliers that do not import parts from abroad.
    // Get their id, name and the number of parts they can offer to supply
    @Query(value="select s  from Supplier s where s.importer=false")
    List<Supplier>getLocalSuppliersInfo();
}
