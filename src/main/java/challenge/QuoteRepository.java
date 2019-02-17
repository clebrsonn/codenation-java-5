package challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Scripts, Integer> {

    @Query("SELECT s.quote FROM scripts s where s.quote.actor = :actor")
    List<Quote> findByActor(@Param("actor") String actor);
}
