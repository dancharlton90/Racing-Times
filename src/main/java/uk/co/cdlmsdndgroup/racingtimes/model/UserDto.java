package uk.co.cdlmsdndgroup.racingtimes.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Long id;
    @NotBlank(message = "firstName field is required.")
    private final String firstName;
    @NotBlank(message = "lastName field is required.")
    private final String lastName;
}
