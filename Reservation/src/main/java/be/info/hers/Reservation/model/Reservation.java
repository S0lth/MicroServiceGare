package be.info.hers.Reservation.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Reservation")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Reservation {
    @Id
    private String id;
    private String clientUserName;
    private long IdTrajet;
}
