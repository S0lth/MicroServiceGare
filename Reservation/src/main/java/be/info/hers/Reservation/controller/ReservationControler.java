package be.info.hers.Reservation.controller;

import be.info.hers.Reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Reservation")
@RequiredArgsConstructor
public class ReservationControler {
    private final ReservationService RS;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReservation(@RequestParam String clientUserName , @RequestParam long garId) {
        RS.create(clientUserName, garId);
    }


}
