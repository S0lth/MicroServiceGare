package be.info.hers.TrajetMicroService.controller;


import be.info.hers.TrajetMicroService.Service.TrajetService;
import be.info.hers.TrajetMicroService.dto.GareRequestDTO;
import be.info.hers.TrajetMicroService.dto.TrajetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Trajet")
@RequiredArgsConstructor
public class TrajetController {

    private final TrajetService trajetService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createTrajet(@RequestBody TrajetDTO trajet) {
        try {
            trajetService.registerTrajet(trajet);
            return "trajet cree";
        }catch (Exception e) {
            return "error gare n'existe pas";
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrajetDTO> getAllTrajets() {
        return trajetService.getAllTrajets();
    }

    @PostMapping("/AddGare")
    @ResponseStatus(HttpStatus.OK)
    public String addGare(@RequestParam Long gare , @RequestParam Long id) {
        try{
            return trajetService.addToTrajet(gare , id);
        }catch (RuntimeException e) {
            return "error gare n'existe pas";
        }
    }

    @GetMapping("/exist")
    @ResponseStatus(HttpStatus.OK)
    public boolean exist(@RequestParam Long id) {
        return trajetService.exist(id);
    }
}
