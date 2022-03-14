package cep.gouv.ht.Controller;


import cep.gouv.ht.Models.Login;
import cep.gouv.ht.Models.PersonneTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping(value = "/getPersonTest", produces = "application/json")
    public ResponseEntity<?> getAllPersonneTes() {
        List<PersonneTest> list = new ArrayList<>();
        list.add(new PersonneTest("1","Obdeus","Stanley",""));
        list.add(new PersonneTest("2","Obdeus","Vladimir",""));
        list.add(new PersonneTest("3","Pierre","Peter",""));
        list.add(new PersonneTest("4","Evens","Noowaw",""));
        list.add(new PersonneTest("5","Norzelus","Myriam",""));
        return ResponseEntity.ok(list);

    }




    @PostMapping(value = "/create", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?>  create(@RequestBody Login login) {

        System.out.println("men login ou "+ login.getPassword()+" "+login.getUsername()+" "+login.getPicture());
        return ResponseEntity.ok(login);

    }
}
