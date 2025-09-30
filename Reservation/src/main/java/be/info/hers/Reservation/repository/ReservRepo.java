package be.info.hers.Reservation.repository;

import be.info.hers.Reservation.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservRepo extends MongoRepository<Reservation, String> {
}
