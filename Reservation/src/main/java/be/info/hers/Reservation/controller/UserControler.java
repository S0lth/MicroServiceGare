package be.info.hers.Reservation.controller;

import be.info.hers.Reservation.dto.UseRequestDTO;
import be.info.hers.Reservation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Reservation/User")
@RequiredArgsConstructor
public class UserControler {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UseRequestDTO user) {
        userService.createUser(user);
    }

    @GetMapping("/exist")
    @ResponseStatus(HttpStatus.OK)
    public boolean exist(@RequestParam String Username) {
        return userService.getThis(Username);
    }



}
