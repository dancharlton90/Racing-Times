package uk.co.cdlmsdndgroup.racingtimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.co.cdlmsdndgroup.racingtimes.model.User;
import uk.co.cdlmsdndgroup.racingtimes.service.UserService;

import javax.validation.Valid;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }
}
