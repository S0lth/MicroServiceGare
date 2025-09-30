package be.info.hers.TrajetMicroService.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
@Table(name = "trajet")
public class Trajet {
    @Id
    private Long id;

    @ElementCollection
    @CollectionTable(
            name = "trajet_gare", // Nom de la table de jointure
            joinColumns = @JoinColumn(name = "trajet_id") // Clé étrangère pour Trajet
    )
    @Column(name = "gare_id") // Colonne pour les IDs des gares
    private List<Long> points;

    @Column(name = "date_debut")
    private LocalDateTime dateDebut ;

    @Column(name = "date_fin")
    private LocalDateTime dateFin;

}
