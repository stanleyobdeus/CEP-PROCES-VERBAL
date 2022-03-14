package cep.gouv.ht.Controller;


import cep.gouv.ht.Models.Departement;
import cep.gouv.ht.Repository.CommuneRepository;
import cep.gouv.ht.Repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/address")
public class HelpperController {
    @Autowired
    DepartementRepository departementRepository;



    @Autowired
    CommuneRepository communeRepository;

    @GetMapping(value = "/getAllDerpartement", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllDepartement(){
        return ResponseEntity.status(HttpStatus.OK).body(departementRepository.findAll());
    }

    @GetMapping(value = "/getAllCommune", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllCommune(){
        return ResponseEntity.status(HttpStatus.OK).body(communeRepository.findAll());
    }

    @GetMapping(value = "/getAllCommunedByDepartement/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllCommuneByIdDepartement(@PathVariable("name") String name){
        Departement departement=departementRepository.getDepartementByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(communeRepository.getAllCommuneByIdDepartement(departement.getCode_dep()));
    }

}
