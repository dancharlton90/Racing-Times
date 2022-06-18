package uk.co.cdlmsdndgroup.racingtimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.cdlmsdndgroup.racingtimes.model.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
}