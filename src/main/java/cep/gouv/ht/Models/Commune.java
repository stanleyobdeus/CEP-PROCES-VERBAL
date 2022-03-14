package cep.gouv.ht.Models;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "commune")
@IdClass(CommuneId.class)
public class Commune  implements Serializable {

    @Id
    @Column(name = "code_com")
    private String code_commune;

    @Id
    @Column(name = "code_dep")
    private String code_dep;

    @Column(name = "comunne")
    private String comunne;

    public Commune() {
    }

    public Commune(String code_commune, String code_dep, String comunne) {
        this.code_commune = code_commune;
        this.code_dep = code_dep;
        this.comunne = comunne;
    }

    public Commune(String code_commune, String code_dep) {
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

    public String getComunne() {
        return comunne;
    }

    public void setComunne(String comunne) {
        this.comunne = comunne;
    }
}
