package cep.gouv.ht.Controller;


import cep.gouv.ht.Bean.UserBean;
import cep.gouv.ht.Exception.AlreadyExistdException;
import cep.gouv.ht.Exception.NotFoundException;
import cep.gouv.ht.Interface.IUserService;
import cep.gouv.ht.Models.*;
import cep.gouv.ht.Repository.CandidatRepository;
import cep.gouv.ht.Repository.ProcesVerbalRepository;
import cep.gouv.ht.Repository.StoreProcessVerbalRepository;
import cep.gouv.ht.Repository.UserRepository;
import cep.gouv.ht.Request.UserReq;
import cep.gouv.ht.Services.FileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    IUserService userService;


    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createUser(@RequestBody UserBean userBean) throws AlreadyExistdException, IOException {
        System.out.println("Username " + userBean.getUsername() + " password " + userBean.getPassword() + " lastname "
                + userBean.getLastname() + "  FirstName " + userBean.getFirstname()
                + " Sexe " + userBean.getGender() + " email " + userBean.getEmail());
        return ResponseEntity.ok("OKKKKKKKKk");
    }

    private final FileService fileService;

    @Autowired
    public UserController(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    ProcesVerbalRepository procesVerbalRepository;

    @Autowired
    CandidatRepository candidatRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StoreProcessVerbalRepository storeProcessVerbalRepository;

    @PostMapping(value = "/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("file_csv") MultipartFile file_csv,
                                             @RequestParam("commune") String commune,
                                             @RequestParam("departement") String departement,
                                             @RequestParam("centre_vote") String centre_vote,
                                             @RequestParam("section") String section,
                                             @RequestParam("code_barre") String code_barre,
                                             @RequestParam("code_bureau") String code_bureau,
                                             @RequestParam("size_image") Integer size_image,
                                             @RequestParam("listCandidat") String listCandidat,
                                             @RequestParam("id_user") String id_user,
                                             @RequestParam("nombre_bultin") String nombre_bultin,
                                             @RequestParam("nombre_bultin_ok") String nombre_bultin_ok,
                                             @RequestParam("nombre_bultin_non_utiliser") String nombre_bultin_non_utiliser,
                                             @RequestParam("nombre_bultin_null") String nombre_bultin_null,
                                             @RequestParam("nombre_fille") String nombre_fille,
                                             @RequestParam("nombre_bultin_echoue") String nombre_bultin_echoue


    ) {


        try {

            if (procesVerbalRepository.getProcesVerbalsByCodebare(code_barre) != null) {
                return ResponseEntity.status(HttpStatus.OK).body("Ce Proces Verbal Est Deja Scanner");
            }

            ObjectMapper mapper = new ObjectMapper();
            List<Candidate> allCandidat = asList(mapper.readValue(listCandidat, Candidate[].class));
            System.out.println("size iamge est " + file.getSize() + " commune " + commune + " size_image " + size_image);
            if (file.getSize() == size_image) {
                ProcesVerbal procesVerbal = new ProcesVerbal();
                procesVerbal.setFile_csv(file_csv.getBytes());
                procesVerbal.setFile_image(file.getBytes());
                procesVerbal.setCommune(commune);
                procesVerbal.setDerpartement(departement);
                procesVerbal.setCentre_vote(centre_vote);
                procesVerbal.setSection(section);
                procesVerbal.setCode_bare(code_barre);
                procesVerbal.setCode_bureau(code_bureau);
                procesVerbal.setCreateBy(Long.valueOf(id_user));
                procesVerbal.setNombre_bulttin(nombre_bultin);
                procesVerbal.setNumber_bultin_faild(nombre_bultin_echoue);
                procesVerbal.setNumber_bultin_not_use(nombre_bultin_non_utiliser);
                procesVerbal.setNumber_bultin_null(nombre_bultin_null);
                procesVerbal.setNumber_bultin_ok(nombre_bultin_ok);
                procesVerbal.setCreataDate(LocalDateTime.now());
                ProcesVerbal entity = procesVerbalRepository.save(procesVerbal);
                Candidate candidate_entity;
                for (Candidate candidate : allCandidat) {
                    candidate_entity = new Candidate();
                    candidate_entity.setCreataDate(LocalDateTime.now());
                    candidate_entity.setEn_chif(candidate.getEn_chif());
                    candidate_entity.setKandidat(candidate.getKandidat());
                    candidate_entity.setParti(candidate.getParti());
                    candidate_entity.setNo(candidate.getNo());
                    candidate_entity.setProcesVerbal(new ProcesVerbal(entity.getId()));
                    candidatRepository.save(candidate_entity);
                }
                if (entity != null) {
                    fileService.save(file);
                    fileService.save(file_csv);
                }
                return ResponseEntity.status(HttpStatus.OK).body("Uploaded the file successfully: " + file.getOriginalFilename());

            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could not upload the file: " + file.getOriginalFilename() + "!");
        }
        return null;

    }

    @GetMapping(value = "/getImageByCodeBare/{code_bare}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProcesVerbal> getImageByCodeBare(@PathVariable("code_bare") String code_bare) throws NotFoundException {
        ProcesVerbal imageProcesVerbal = procesVerbalRepository.getProcesVerbalsByCodebare(code_bare);
        if (imageProcesVerbal == null) {
            throw new NotFoundException("Proces Verbal Deja Inregistrer");
        }
        System.out.println("found process Verbale");

        return ResponseEntity.status(HttpStatus.OK).body(new ProcesVerbal(imageProcesVerbal.getFile_image()));
    }


    @GetMapping("/search/listProcesVerbal")
    public ResponseEntity<List<ProcesVerbal>> searchTBINVENTORYCARTES(@RequestParam String query, Pageable pageable) {
        /*log.debug("REST request to search for a page of TBINVENTORYCARTES for query {}", query);
        Page<TBINVENTORYCARTES> page = tBINVENTORYCARTESService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());*/
        return null;
    }


    @GetMapping(value = "/getAllProcesVerbal", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ProcesVerbal>> getAllProcesVerbal() {
        return ResponseEntity.status(HttpStatus.OK).body(procesVerbalRepository.getAllProcesVerbals());
    }

    @GetMapping(value = "/getAllUsers", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.findAll());
    }

    @GetMapping(value = "/getAllStoreProcesVerbal", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<StoreProcesVerbal>> getAllStoreProcesVerbal() {
        return ResponseEntity.status(HttpStatus.OK).body(storeProcessVerbalRepository.findAll());
    }

    @PostMapping(value = "/SaveStoreProcesVerbal", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> SaveStoreProcesVerbal(@RequestBody UserReq storeProcesVerbal) {

        StoreProcesVerbal store= new StoreProcesVerbal(
                "Ouest",
                "Petion Ville",
                "La boule 18",
                "Lycee Petion Ville",
                "00928",
                "3782939434",
                "D783624",null
               );

//        asList(new JsonCandidat("child1","","",""),
//                (new JsonCandidat("child1","","","")) )
         List<JsonCandidat> lc = new ArrayList<>();
         lc.add(new JsonCandidat("child1","","",""));
         lc.add(new JsonCandidat("child1","","",""));
         store = storeProcessVerbalRepository.save(store);
         store.setListCandidat(lc);
        store = storeProcessVerbalRepository.save(store);
        return ResponseEntity.status(HttpStatus.OK).body(store);
    }

    @MessageMapping("/send")
    // Sends the return value of this method to /topic/messages
    @SendTo("/topic/messages")
    public Messagerie getMessages(@Payload String message) {
        System.out.println("yonnnnnnnnnnnnnn " + message);

        return new Messagerie(message);

    }
}
