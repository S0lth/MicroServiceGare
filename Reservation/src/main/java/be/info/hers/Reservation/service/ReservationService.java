package be.info.hers.Reservation.service;

import be.info.hers.Reservation.model.Reservation;
import be.info.hers.Reservation.repository.ReservRepo;
import be.info.hers.Reservation.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReservationService {
    private final ReservRepo rp;
    private final UserRepo ur;
    private final WebClient.Builder wc;

    public void create(String clientUserName , long trajet){

        if(getThis(clientUserName) && existTrajet(trajet)){
            Reservation reservation = Reservation.builder()
                    .clientUserName(clientUserName)
                    .IdTrajet(trajet).build();
            Reservation savedReservation = rp.save(reservation);
            log.info("created reservation: {}", savedReservation);
        }else{
            log.info("fail");
        }

    }

    public boolean existTrajet(long TrajetID){
        try {
            return wc.build().get()
                    .uri("http://Trajet/api/Trajet/exist?id={id}", TrajetID)
                    .retrieve()
                    .bodyToMono(boolean.class)
                    .block();
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
    public boolean getThis(String Username) {
        return ur.findByUsername(Username).isPresent();
    }
}
