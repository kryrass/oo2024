package ee.tlu.salat;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {

    List<ToiduaineEntity> findAllByValkGreaterThan(int valk);

    List<ToiduaineEntity> findAllBySysivesikBetween(int min, int max);

}
