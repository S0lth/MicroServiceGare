package be.info.hers.ProjetMicroservice.Service;

import be.info.hers.ProjetMicroservice.Model.Gare;
import be.info.hers.ProjetMicroservice.dto.GareRequestDTO;
import be.info.hers.ProjetMicroservice.dto.GareResponseDTO;
import be.info.hers.ProjetMicroservice.repostiroy.GareRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GareService {
    private final GareRepository gareRepository;
    public void createGare(GareRequestDTO grDTO){

        Gare gare = Gare.builder()
                .id(grDTO.getId())
                .Rue(grDTO.getRue())
                .Ville(grDTO.getVille())
                .Name(grDTO.getName())
                .Numero(grDTO.getNumero())
                .CodePostal(grDTO.getCodePostal()).build();
        gareRepository.save(gare);
        log.info("Gare created");
    }

    public List<GareResponseDTO> getAllGare() {
        List<Gare> gareList = gareRepository.findAll();
        return gareList.stream().map( gare -> mapToGareResponse(gare)).toList();

    }

    private GareResponseDTO mapToGareResponse(Gare gare){
        return GareResponseDTO.builder()
                .id(gare.getId())
                .Name(gare.getName())
                .Ville(gare.getVille())
                .Rue(gare.getRue())
                .Numero(gare.getNumero())
                .CodePostal(gare.getCodePostal()).build();
    }

    public boolean getThis(Long gare) {
        return gareRepository.findById(String.valueOf(gare)).isPresent();
    }
}
