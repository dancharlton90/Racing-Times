package uk.co.cdlmsdndgroup.racingtimes.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Validated
@Table(name = "race", uniqueConstraints = {
        @UniqueConstraint(name = "UniqueDateVenueRaceNumber", columnNames = {"date", "venue_id", "raceNumber"})
})
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "date field is required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull(message = "raceNumber field is required.")
    @Range(min = 1, message = "raceNumber cannot be 0, empty or null.")
    private int raceNumber;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "race_users",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"))
    private List<User> users = new java.util.ArrayList<>();


    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "race_lap_times",
            joinColumns = @JoinColumn(name = "race_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lap_times_id", referencedColumnName = "id"))
    private List<LapTime> lapTimes = new java.util.ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}