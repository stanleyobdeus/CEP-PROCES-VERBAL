package cep.gouv.ht.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(	name = "image")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    private String image_base64;

    @Column(name = "filname")
    private String filname;

    @Column(name = "type")
    private String type;

    @Column(name = "contentype")
    private String contentype;

    @Column(name = "imagebyte")
    private byte[] image;



    @Column(name = "filesize")
    private Long file_size;

    public Images(String filname, String type, String contentype, byte[] image, Long file_size) {
        this.filname = filname;
        this.type = type;
        this.contentype = contentype;
        this.image = image;
        this.file_size = file_size;
    }

    public Images(String image_base64) {
        this.image_base64=image_base64;
    }

/*    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage_base64() {
        return image_base64;
    }

    public void setImage_base64(String image_base64) {
        this.image_base64 = image_base64;
    }

    public String getFilname() {
        return filname;
    }

    public void setFilname(String filname) {
        this.filname = filname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getContentype() {
        return contentype;
    }

    public void setContentype(String contentype) {
        this.contentype = contentype;
    }*/
}
