package cep.gouv.ht.Controller;


import cep.gouv.ht.Models.CentreVote;
import cep.gouv.ht.Repository.CentreVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/centre-vote")
public class CentreVoteControlleur {

    @Autowired
    CentreVoteRepository centreVoteRepository;

    @GetMapping(value = "/getCentrevoteByPagination", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<CentreVote>> getcentrevote(Pageable pageable)  {
        Page<CentreVote> pageCentre = centreVoteRepository.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(pageCentre.getContent());
    }
}
