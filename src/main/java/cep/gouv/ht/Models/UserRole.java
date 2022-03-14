package cep.gouv.ht.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_roles")
@IdClass(UserRoleId.class)
public class UserRole implements Serializable {

    @Id
    private Long user_id;
    @Id
    private Integer role_id;

    public UserRole() {
    }

    public UserRole(Long user_id, int role_id) {
        this.user_id=user_id;
        this.role_id=role_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "user_id=" + user_id +
                ", role_id=" + role_id +
                '}';
    }
}
