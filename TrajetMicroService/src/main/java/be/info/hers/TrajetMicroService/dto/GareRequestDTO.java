package be.info.hers.TrajetMicroService.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GareRequestDTO {
    private Long id;
    private String Name;
    private String Rue;
    private String Ville;
    private Integer CodePostal;
    private Integer Numero;
}
