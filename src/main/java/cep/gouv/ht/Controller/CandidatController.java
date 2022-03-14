package cep.gouv.ht.Controller;

import cep.gouv.ht.Models.Candidatee;
import cep.gouv.ht.Models.Images;
import cep.gouv.ht.Repository.CandidateRepository;
import cep.gouv.ht.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/candidat")
public class CandidatController {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    ImageRepository imageRepository;

    @PostMapping(value = "/save")
    public ResponseEntity<Candidatee> saveCandidate(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("nom") String nom,
                                                    @RequestParam("prenom") String prenom,
                                                    @RequestParam("sexe") String sexe,
                                                    @RequestParam("departement") String departement,
                                                    @RequestParam("commune") String commune,
                                                    @RequestParam("section") String section,
                                                    @RequestParam("partie") String partie,
                                                    @RequestParam("address") String address,
                                                    @RequestParam("telephone") String telephone,
                                                    @RequestParam("email") String email) throws IOException {
        Images images = imageRepository.save(new Images(file.getOriginalFilename(), file.getContentType(), file.getContentType(), file.getBytes(), file.getSize()));
        return ResponseEntity.status(HttpStatus.OK).body(candidateRepository.save(new Candidatee(LocalDateTime.now(),nom, prenom,partie,sexe, departement,  commune, section,  telephone,  email,  address,images)));

    }


    @GetMapping(value = "/getAllCandidat", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Candidatee>> getAllCandidat() {
        return ResponseEntity.status(HttpStatus.OK).body(candidateRepository.getCandidatWithoutImage());
    }
}
