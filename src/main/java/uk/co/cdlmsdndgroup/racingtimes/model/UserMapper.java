package uk.co.cdlmsdndgroup.racingtimes.model;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto entityToDto(User user) {
        return new UserDto(user.getId(), user.getFirstName(), user.getLastName());
    }
}
