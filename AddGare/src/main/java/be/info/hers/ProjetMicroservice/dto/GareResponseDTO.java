package be.info.hers.ProjetMicroservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GareResponseDTO {
    private Long id;
    private String Name;
    private String Rue;
    private String Ville;
    private Integer CodePostal;
    private Integer Numero;

}
