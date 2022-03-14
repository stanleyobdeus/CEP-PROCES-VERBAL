package cep.gouv.ht.Utils;


import cep.gouv.ht.Models.User;
import cep.gouv.ht.Repository.CentreVoteRepository;
import cep.gouv.ht.Repository.CommuneRepository;
import cep.gouv.ht.Repository.DepartementRepository;
import cep.gouv.ht.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InsertCommandLineRunner implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    User user;

    @Autowired
    DepartementRepository departementRepository;

    @Autowired
    CentreVoteRepository centreVoteRepository;

    @Autowired
    CommuneRepository communeRepository;

    @Override
    public void run(String... args) throws Exception {


/*
        FileInputStream fileInputStream = new FileInputStream( "src/main/resources/centreVote.xlsx");

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        Row row;
        for (int i = 1; i <= xssfSheet.getLastRowNum(); i++) {
            row = xssfSheet.getRow(i);

            // System.err.println(row.getCell(0) + " " + " " + row.getCell(1) + " " + row.getCell(2)+ " " + " " + row.getCell(3) + " " + row.getCell(4)+ " " + " " + row.getCell(5) + " " + row.getCell(6)+ " " + " " + row.getCell(7) + " " + row.getCell(8)+ " " + " " + row.getCell(9) + " " + row.getCell(10)+ " " + " " + row.getCell(11) + " " + row.getCell(12));


            if (!departementRepository.findById(row.getCell(i) + "").isPresent())
                departementRepository.save(new Departement(row.getCell(0) + "", row.getCell(1) + ""));



            communeRepository.save(new Commune(row.getCell(4) + "", row.getCell(0) + "", row.getCell(5) + ""));

//           if (centreVoteRepository.count() == 0)
                centreVoteRepository.save(new CentreVote(row.getCell(0) + " ", row.getCell(4) + " ", row.getCell(6) + " ", row.getCell(8) + " ", row.getCell(9) + " ", row.getCell(10) + " ",row.getCell(11) + " " ));


        }

        xssfWorkbook.close();*/


        if (userRepository.count() == 0) {
            //user Mobile


            user = new User();
            user.setUsername("stanley");
            user.setPassword(encoder.encode("stanley"));
            user.setFirstname("Stanley");
            user.setLastname("Obdeus");
            user.setGender("Male");
            user.setCreateDate(LocalDateTime.now());
            userRepository.save(user);

            user = new User();
            user.setUsername("cherilus");
            user.setPassword(encoder.encode("cherilus"));
            user.setFirstname("Robenson");
            user.setLastname("Cherilus");
            user.setGender("Male");
            user.setCreateDate(LocalDateTime.now());
            userRepository.save(user);

            user = new User();
            user.setUsername("steve");
            user.setPassword(encoder.encode("steve"));
            user.setFirstname("Steve");
            user.setLastname("Calet");
            user.setGender("Male");
            user.setCreateDate(LocalDateTime.now());
            userRepository.save(user);

            user = new User();
            user.setUsername("charite");
            user.setPassword(encoder.encode("charite"));
            user.setFirstname("Edrice");
            user.setLastname("Charite");
            user.setGender("Male");
            user.setCreateDate(LocalDateTime.now());
            userRepository.save(user);

            user = new User();
            user.setUsername("akoi");
            user.setPassword(encoder.encode("akoi"));
            user.setFirstname("Akoi");
            user.setLastname("Sylveste");
            user.setGender("Male");
            user.setCreateDate(LocalDateTime.now());
            userRepository.save(user);

        }
    }
}
