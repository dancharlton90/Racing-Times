package uk.co.cdlmsdndgroup.racingtimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uk.co.cdlmsdndgroup.racingtimes.model.Race;
import uk.co.cdlmsdndgroup.racingtimes.model.RaceDto;
import uk.co.cdlmsdndgroup.racingtimes.model.RaceMapper;
import uk.co.cdlmsdndgroup.racingtimes.service.RaceService;

import javax.validation.Valid;

@RestController
public class RaceApiController {

    @Autowired
    RaceService raceService;
    @Autowired
    RaceMapper raceMapper;

    @GetMapping("/race")
    public ResponseEntity<?> getAllRaces() {
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @PostMapping("/race")
    public ResponseEntity<?> addRace(@RequestBody @Valid @DateTimeFormat(pattern = "yyyy-MM-dd") RaceDto raceDto) {

        try {
            Race race = raceMapper.dtoToEntity(raceDto);
            raceService.addRace(race);
            return ResponseEntity.ok(race);
        } catch (ResponseStatusException e) {
            throw e;
        } catch (Exception f) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The race already exists");
        }
    }
}
