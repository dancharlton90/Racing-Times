package uk.co.cdlmsdndgroup.racingtimes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.cdlmsdndgroup.racingtimes.model.Race;
import uk.co.cdlmsdndgroup.racingtimes.repository.RaceRepository;

import java.util.List;

@Service
public class RaceService {

    @Autowired
    RaceRepository raceRepo;

    public List<Race> getAllRaces() {
        return raceRepo.findAll();
    }

    public void addRace(Race race) {
        raceRepo.save(race);
    }
}
