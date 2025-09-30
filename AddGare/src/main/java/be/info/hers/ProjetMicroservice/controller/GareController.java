package be.info.hers.ProjetMicroservice.controller;


import be.info.hers.ProjetMicroservice.Service.GareService;
import be.info.hers.ProjetMicroservice.dto.GareRequestDTO;
import be.info.hers.ProjetMicroservice.dto.GareResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gare")
@RequiredArgsConstructor
public class GareController {
    private final GareService gareService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGare(@RequestBody GareRequestDTO gare) {
        gareService.createGare(gare);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GareResponseDTO> getAllGares() {
        return gareService.getAllGare();
    }


    @GetMapping("/GetOne")
    @ResponseStatus(HttpStatus.OK)
    public boolean exist(@RequestParam Long gare) {
        return gareService.getThis(gare);
    }

}
