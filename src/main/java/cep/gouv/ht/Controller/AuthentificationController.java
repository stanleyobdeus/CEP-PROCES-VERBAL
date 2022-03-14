package cep.gouv.ht.Controller;



import cep.gouv.ht.Bean.UserBean;
import cep.gouv.ht.Exception.NotFoundException;
import cep.gouv.ht.Interface.IUserService;
import cep.gouv.ht.Models.LoginRequest;
import cep.gouv.ht.Models.LoginResponse;
import cep.gouv.ht.Securiry.jwt.JwtUtils;
import cep.gouv.ht.Utils.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authentification")
public class AuthentificationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    IUserService userService;

    @Autowired
    PasswordEncoder encoder;
    String jwt = null;


    @PostMapping(value = "/signin", produces = "application/json")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws NotFoundException {

        UserBean userBean = userService.getUserByUsername(loginRequest.getUsername());
        if (userBean==null || !encoder.matches(loginRequest.getPassword(), userBean.getPassword())) {
            System.out.println("Username Ou Password Incorrect");
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwt = jwtUtils.generateJwtToken(authentication);
        System.out.println("Authentification Reussie");
        return ResponseEntity.ok(new LoginResponse(jwt, null));
    }

}
