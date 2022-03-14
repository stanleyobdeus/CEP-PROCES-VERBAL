package cep.gouv.ht.Models;

import java.io.Serializable;

public class CommuneId  implements Serializable {

    private String code_commune;

    private String code_dep;

    public CommuneId() {
    }

    public CommuneId(String code_commune, String code_dep) {
        this.code_commune = code_commune;
        this.code_dep = code_dep;
    }

    public String getCode_commune() {
        return code_commune;
    }

    public void setCode_commune(String code_commune) {
        this.code_commune = code_commune;
    }

    public String getCode_dep() {
        return code_dep;
    }

    public void setCode_dep(String code_dep) {
        this.code_dep = code_dep;
    }
}
