package uk.co.cdlmsdndgroup.racingtimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.co.cdlmsdndgroup.racingtimes.model.Venue;
import uk.co.cdlmsdndgroup.racingtimes.service.VenueService;

import javax.validation.Valid;

@RestController
public class VenueApiController {

    @Autowired
    VenueService venueService;

    @PostMapping("/addVenue")
    public ResponseEntity<?> addVenue(@RequestBody @Valid Venue venue) {
        venueService.addVenue(venue);
        return ResponseEntity.ok(venue);
    }
}
