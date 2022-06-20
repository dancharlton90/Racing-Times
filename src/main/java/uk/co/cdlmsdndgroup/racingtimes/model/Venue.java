package uk.co.cdlmsdndgroup.racingtimes.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@Validated
@Entity
@Table(name = "venue",
        uniqueConstraints = {@UniqueConstraint(name = "UniqueNameAndLocation", columnNames = {"name", "location"})})
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "name field is required.")
    private String name;

    @NotBlank(message = "location field is required.")
    private String location;
}