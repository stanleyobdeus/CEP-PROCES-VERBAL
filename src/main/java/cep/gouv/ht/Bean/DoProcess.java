package cep.gouv.ht.Bean;

import java.io.Serializable;

public class DoProcess implements Serializable {
    private Long id;
    private Integer process_id;
    private String code_bureau;
    private String code_bare;
    private String departement;
    private String commune;
    private String section;
    private String centre_vote;
    private String already_send;
    private String number_candidat;
    private String name_file_csv;
    private String size_file_csv;
    private String name_file_jpg;
    private String size_file_jpg;

    public DoProcess() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProcess_id() {
        return process_id;
    }


    public void setProcess_id(Integer process_id) {
        this.process_id = process_id;
    }

    public String getCode_bureau() {
        return code_bureau;
    }

    public void setCode_bureau(String code_bureau) {
        this.code_bureau = code_bureau;
    }

    public String getCode_bare() {
        return code_bare;
    }

    public void setCode_bare(String code_bare) {
        this.code_bare = code_bare;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getCentre_vote() {
        return centre_vote;
    }

    public void setCentre_vote(String centre_vote) {
        this.centre_vote = centre_vote;
    }

    public String getAlready_send() {
        return already_send;
    }

    public void setAlready_send(String already_send) {
        this.already_send = already_send;
    }

    public String getNumber_candidat() {
        return number_candidat;
    }

    public void setNumber_candidat(String number_candidat) {
        this.number_candidat = number_candidat;
    }

    public String getName_file_csv() {
        return name_file_csv;
    }

    public void setName_file_csv(String name_file_csv) {
        this.name_file_csv = name_file_csv;
    }

    public String getSize_file_csv() {
        return size_file_csv;
    }

    public void setSize_file_csv(String size_file_csv) {
        this.size_file_csv = size_file_csv;
    }

    public String getName_file_jpg() {
        return name_file_jpg;
    }

    public void setName_file_jpg(String name_file_jpg) {
        this.name_file_jpg = name_file_jpg;
    }

    public String getSize_file_jpg() {
        return size_file_jpg;
    }

    public void setSize_file_jpg(String size_file_jpg) {
        this.size_file_jpg = size_file_jpg;
    }
}
