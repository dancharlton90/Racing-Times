package uk.co.cdlmsdndgroup.racingtimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import uk.co.cdlmsdndgroup.racingtimes.model.User;
import uk.co.cdlmsdndgroup.racingtimes.service.UserService;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists.");
        }
    }
}
