package be.info.hers.Reservation.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UseRequestDTO {

    private String username;
    private String lastname;
    private String firstname;

}
