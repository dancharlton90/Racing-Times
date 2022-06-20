package uk.co.cdlmsdndgroup.racingtimes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import uk.co.cdlmsdndgroup.racingtimes.repository.UserRepository;
import uk.co.cdlmsdndgroup.racingtimes.repository.VenueRepository;
import uk.co.cdlmsdndgroup.racingtimes.service.VenueService;

import java.util.Optional;

@Service
public class RaceMapper {

    @Autowired VenueRepository venueRepo;
    @Autowired UserRepository userRepo;


    public Race dtoToEntity(RaceDto raceDto) {
        Race race = new Race();
        race.setDate(raceDto.getDate());
        race.setRaceNumber(raceDto.getRaceNumber());

        // Get venue from ID
        Optional<Venue> venue = venueRepo.findById(raceDto.getVenueId());
        if (venue.isPresent()) {
            race.setVenue(venue.get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Venue ID was not found.");
        }

        // Get Users from IDs
        if (raceDto.getUserIds() != null) {
            for (Long userId : raceDto.getUserIds()) {
                Optional<User> user = userRepo.findUserById(userId);
                if (user.isPresent()) {
                    race.addUser(user.get());
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User ID: " + userId + " was not found.");
                }
            }
        }
        return race;
    }
}
