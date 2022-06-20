package uk.co.cdlmsdndgroup.racingtimes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.cdlmsdndgroup.racingtimes.model.User;
import uk.co.cdlmsdndgroup.racingtimes.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    // Saves and returns user
    public void addUser(User user) {
        userRepo.save(user);
    }

    public List<User> getUserList() {
        return userRepo.findAll();
    }
}
