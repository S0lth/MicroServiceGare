package be.info.hers.ProjetMicroservice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "gare")
public class Gare {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String Name;

    @Column(name = "rue")
    private String Rue;

    @Column(name = "ville")
    private String Ville;

    @Column(name = "code_postal")
    private Integer CodePostal;

    @Column(name = "numero")
    private Integer Numero;
}
