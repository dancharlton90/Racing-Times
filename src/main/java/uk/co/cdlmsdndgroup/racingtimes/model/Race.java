package uk.co.cdlmsdndgroup.racingtimes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Validated
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToMany
    @JoinTable(name = "race_users",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<User> users;


    @ManyToMany
    @JoinTable(name = "race_lap_times",
            joinColumns = @JoinColumn(name = "race_id"),
            inverseJoinColumns = @JoinColumn(name = "lap_times_id"))
    private List<LapTime> lapTimes;
}