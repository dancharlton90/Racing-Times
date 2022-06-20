package uk.co.cdlmsdndgroup.racingtimes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Validated
public class RaceDto implements Serializable {

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "date field is required.")
    private final LocalDate date;

    @NotNull(message = "raceNumber field is required.")
    @Range(min = 1, message = "raceNumber cannot be 0, empty or null.")
    private final int raceNumber;

    @NotNull(message = "raceNumber field is required.")
    @Range(min = 1, message = "venueId cannot be 0, empty or null.")
    private final long venueId;

    private final List<Long> userIds;

    private final List<Long> lapTimeIds;
}
