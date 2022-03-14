package cep.gouv.ht.Models;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleId  implements Serializable {
    private Long user_id;
    private Integer role_id;

    public UserRoleId(Long user_id, Integer role_id) {
        this.user_id = user_id;
        this.role_id = role_id;
    }

    public UserRoleId() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(user_id, that.user_id) &&
                Objects.equals(role_id, that.role_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, role_id);
    }
}
