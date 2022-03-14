package cep.gouv.ht.Bean;


public class ImagesBean {

    private Long id;
    private byte[] image;
    private String filname;
    private String type;
    private Long file_size;
    private String contentype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public String getContentype() {
        return contentype;
    }

    public void setContentype(String contentype) {
        this.contentype = contentype;
    }
}
