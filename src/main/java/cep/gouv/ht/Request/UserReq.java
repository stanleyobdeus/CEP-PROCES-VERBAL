package cep.gouv.ht.Request;

import lombok.Data;

import java.util.List;

@Data
public class UserReq {

    private String derpartement;

    private String commune;

    private String section;
    private String centre_vote;
    private String code_bureau;
    private String office_code;

    private String code_bare;

    private List<Object> listCandidat;
}
