package cep.gouv.ht.Bean;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet
public class CentreVoteBean {

    @SheetColumn("ADRESSE")
    private String adresse;

    @SheetColumn("BUREAU_VOTE")
    private String bureau_vote;

    @SheetColumn("DESCRIPTION")
    private String description;

    @SheetColumn("COD_CV")
    private String cod_cv;

    public CentreVoteBean() {
    }

    public CentreVoteBean(String adresse, String bureau_vote, String description, String cod_cv) {
        this.adresse = adresse;
        this.bureau_vote = bureau_vote;
        this.description = description;
        this.cod_cv = cod_cv;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getBureau_vote() {
        return bureau_vote;
    }

    public void setBureau_vote(String bureau_vote) {
        this.bureau_vote = bureau_vote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCod_cv() {
        return cod_cv;
    }

    public void setCod_cv(String cod_cv) {
        this.cod_cv = cod_cv;
    }
}
