package cep.gouv.ht.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistdException extends Exception {

    public AlreadyExistdException(String msg) {
        super(msg );
    }
}
