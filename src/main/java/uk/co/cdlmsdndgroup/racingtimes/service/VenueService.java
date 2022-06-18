package uk.co.cdlmsdndgroup.racingtimes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.cdlmsdndgroup.racingtimes.model.Venue;
import uk.co.cdlmsdndgroup.racingtimes.repository.VenueRepository;

@Service
public class VenueService {

    @Autowired
    VenueRepository venueRepo;

    public void addVenue(Venue venue) {
        venueRepo.save(venue);
    }
}
