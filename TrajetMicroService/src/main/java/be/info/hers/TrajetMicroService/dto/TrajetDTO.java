package be.info.hers.TrajetMicroService.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrajetDTO {
    private Long id;
    private List<Long> points;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
}
