package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlayerRepository  extends JpaRepository<Player,Integer> {

    @Query(value = "select p from Player as p where p.team.name = 'North Hub' order by p.id")
    List<Player>findAllPlayerByTeam();

    List<Player> findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal bigDecimal);

}
