package cep.gouv.ht.Models;

import javax.persistence.*;

@Entity
@Table(name = "departement")

public class Departement {
    @Id
    @Column(name = "code_dep")
    private String code_dep;

    @Column(name = "departement")
    private String departement;

    public Departement() {
    }

    public Departement(String code_dep, String departement) {
        this.code_dep = code_dep;
        this.departement = departement;
    }

    public String getCode_dep() {
        return code_dep;
    }

    public void setCode_dep(String code_dep) {
        this.code_dep = code_dep;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
