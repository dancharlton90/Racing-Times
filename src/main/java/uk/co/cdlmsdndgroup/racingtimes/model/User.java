package uk.co.cdlmsdndgroup.racingtimes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users",
        uniqueConstraints = {@UniqueConstraint(name = "UniqueFirstAndLastName", columnNames = {"firstName", "lastName"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "firstName field is required.")
    private String firstName;

    @NotBlank(message = "lastName field is required.")
    private String lastName;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "race_users",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "race_id"))
    private List<Race> races;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}