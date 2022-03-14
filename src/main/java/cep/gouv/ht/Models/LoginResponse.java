package cep.gouv.ht.Models;

public class LoginResponse {
    private String token;
    private Error error;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse(String token, Error error) {
        this.token = token;
        this.error = error;
    }


    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
