package be.info.hers.TrajetMicroService.Service;

import be.info.hers.TrajetMicroService.Model.Trajet;
import be.info.hers.TrajetMicroService.dto.TrajetDTO;
import be.info.hers.TrajetMicroService.repostiroy.TrajetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class TrajetService {
    private final TrajetRepository trajetRepository;
    private final WebClient.Builder wc;

    public void registerTrajet(TrajetDTO trajetDTO) {
        Trajet trajet = new Trajet();
        trajet.setId(trajetDTO.getId());

        List<Long> pointIds = new ArrayList<>(trajetDTO.getPoints());

        for(Long x : pointIds){
            if(!fetchGareById(x)){
               throw new RuntimeException();
            }
        }
        trajet.setPoints(pointIds); // Définir la liste des IDs
        trajet.setDateDebut(trajetDTO.getDateDebut());
        trajet.setDateFin(trajetDTO.getDateFin());

        trajetRepository.save(trajet);
    }

    public List<TrajetDTO> getAllTrajets() {
        List<Trajet> trajets = trajetRepository.findAll(); // Récupérer tous les trajets depuis la base
        return trajets.stream()
                .filter(trajet -> trajet.getDateFin().isAfter(LocalDateTime.now()))
                .map(this::mapToTrajetDTO)
                .collect(Collectors.toList());
    }

    private TrajetDTO mapToTrajetDTO(Trajet trajet) {
        List<Long> points = trajet.getPoints().stream()
                .collect(Collectors.toList());

        return TrajetDTO.builder()
                .id(trajet.getId())
                .points(points)
                .dateDebut(trajet.getDateDebut())
                .dateFin(trajet.getDateFin())
                .build();
    }

    private boolean fetchGareById(Long gareId) {
        try {
            return wc.build().get()
                    .uri("http://addGare/api/Gare/GetOne?gare={gare}", gareId)
                    .retrieve()
                    .bodyToMono(boolean.class)
                    .block();
        } catch (Exception e) {
            return false;
        }
    }

    public String addToTrajet(long gareId, long trajetId) {
        try {
            Trajet trajet = trajetRepository.findById(trajetId)
                    .orElseThrow(() -> new RuntimeException("Trajet not found"));


            if(!fetchGareById(gareId)){
                throw new RuntimeException();
            }

                trajet.getPoints().add(gareId);
                trajetRepository.save(trajet);
                return "ok";


        } catch (RuntimeException e) {
            return "Erreur lors de l'ajout de la gare : " + e.getMessage();
        }
    }

    public boolean exist(long id){
        return trajetRepository.findById(id).isPresent();
    }
}
