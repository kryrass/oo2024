package ee.tlu.kodutoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KodutooRepository extends JpaRepository<KodutooEntity, Long> {

    List<KodutooEntity> findAllByNumberLessThan(int minNumber);

    List<KodutooEntity> findAllByNumberBetween(int min, int max);
}
