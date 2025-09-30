package be.info.hers.TrajetMicroService.repostiroy;

import be.info.hers.TrajetMicroService.Model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrajetRepository extends JpaRepository<Trajet, Long> {
}
