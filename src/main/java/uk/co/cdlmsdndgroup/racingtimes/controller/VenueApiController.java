package uk.co.cdlmsdndgroup.racingtimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uk.co.cdlmsdndgroup.racingtimes.model.Venue;
import uk.co.cdlmsdndgroup.racingtimes.service.VenueService;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;

@RestController
public class VenueApiController {

    @Autowired
    VenueService venueService;

    @GetMapping("/venue")
    public ResponseEntity<?> getVenues() {
        return ResponseEntity.ok(venueService.getAllVenues());
    }

    @PostMapping("/venue")
    public ResponseEntity<?> addVenue(@RequestBody @Valid Venue venue) {
        try {
            venueService.addVenue(venue);
            return ResponseEntity.ok(venue);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location already exists.");
        }
    }
}
