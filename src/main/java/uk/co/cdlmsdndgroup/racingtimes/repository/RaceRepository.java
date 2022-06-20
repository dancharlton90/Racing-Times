package uk.co.cdlmsdndgroup.racingtimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.cdlmsdndgroup.racingtimes.model.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {
}