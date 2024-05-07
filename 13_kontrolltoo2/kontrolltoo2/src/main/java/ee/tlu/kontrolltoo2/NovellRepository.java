package ee.tlu.kontrolltoo2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//Näita API otspunkti kaudu kõige vanemat novelli, - tehtud
// kõige lühema tähemärkidega sisuga novelli. - tehtud
// Tee API otspunkt mis näitab kõiki novelle mis on uuemad kui sisestatav aasta. - tehtud

public interface NovellRepository extends JpaRepository<Novell, Long> {

    Novell findFirstByOrderByAastaAsc();

    @Query(value = "SELECT n FROM Novell n ORDER BY LENGTH(n.sisu) ASC LIMIT 1")
    Novell findNovellWithShortestSisu();

    List<Novell> findByAastaGreaterThan(int aasta);


    List<Novell> findByRaamat_Id(Long raamatId);



}
