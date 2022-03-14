package cep.gouv.ht.Models;


import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "storeprocesverbal")
@TypeDef(name = "jsonb", typeClass = JsonNodeBinaryType.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreProcesVerbal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "derpartement")
    private String derpartement;


    @Column(name = "commune")
    private String commune;


    @Column(name = "section")
    private String section;

    @Column(name = "centre_vote")
    private String centre_vote;

    @Column(name = "code_bureau")
    private String code_bureau;

    @Column(name = "office_code")
    private String office_code;


    @Column(name = "code_bare")
    private String code_bare;


    @Type(type = "jsonb")
    @Column(name = "listCandidat", columnDefinition = "jsonb")
    private List<JsonCandidat> listCandidat=new ArrayList<>();

    public StoreProcesVerbal(String derpartement, String commune, String section, String centre_vote, String code_bureau, String office_code, String code_bare, List<JsonCandidat> listCandidat) {
        this.derpartement = derpartement;
        this.commune = commune;
        this.section = section;
        this.centre_vote = centre_vote;
        this.code_bureau = code_bureau;
        this.office_code = office_code;
        this.code_bare = code_bare;
        this.listCandidat = listCandidat;
    }

    @Override
    public String toString() {
        return "StoreProcesVerbal{" +
                "id=" + id +
                ", derpartement='" + derpartement + '\'' +
                ", commune='" + commune + '\'' +
                ", section='" + section + '\'' +
                ", centre_vote='" + centre_vote + '\'' +
                ", code_bureau='" + code_bureau + '\'' +
                ", office_code='" + office_code + '\'' +
                ", code_bare='" + code_bare + '\'' +
                ", listCandidat=" + listCandidat +
                '}';
    }
}
