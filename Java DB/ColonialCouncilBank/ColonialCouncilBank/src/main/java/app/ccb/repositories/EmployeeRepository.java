package app.ccb.repositories;

import app.ccb.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByFirstNameAndLastName(String firstName,String lastName);

    @Query(value = "select e from Employee  as e where size(e.clients) >0 order by size(e.clients) desc,e.id ")
    List<Employee> findAllEmployeesWithClients();
}
