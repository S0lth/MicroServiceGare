package be.info.hers.Reservation.service;

import be.info.hers.Reservation.dto.UseRequestDTO;
import be.info.hers.Reservation.model.User;
import be.info.hers.Reservation.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepo UR;

    public void createUser(UseRequestDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("Le UserRequestDTO ne peut pas être null.");
        }

        User user = User.builder()
                .username(userDTO.getUsername())
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .build();

        User savedUser = UR.save(user);
        log.info("Utilisateur créé avec succès : {}", savedUser);
    }

    public boolean getThis(String Username) {
        return UR.findByUsername(Username).isPresent();
    }
}
