package cep.gouv.ht.Interface;


import cep.gouv.ht.Bean.RoleBean;
import cep.gouv.ht.Bean.UserBean;
import cep.gouv.ht.Exception.AlreadyExistdException;
import cep.gouv.ht.Exception.NotFoundException;
import java.io.IOException;
import java.util.List;


public interface IUserService {

    UserBean saveUser(UserBean userBean) throws AlreadyExistdException, IOException;

    List<UserBean> findAllUser();

    String deleteUser(String id) throws NotFoundException;

    String updateUser(UserBean userBean) throws NotFoundException, AlreadyExistdException;

    public String addRoleToUser(String id_user, String id_role) throws NotFoundException, AlreadyExistdException;

    public String removeRoleToUser(String id_user, String id_role)throws NotFoundException, AlreadyExistdException;

    public UserBean getUserByUsername(String user_name)throws NotFoundException;

    public RoleBean createRole(RoleBean roleMBean) throws AlreadyExistdException;

    public UserBean getUserById(String id_user)throws NotFoundException;

    public String changePassword(String username, Long id_organisation, String old_password, String new_password) throws NotFoundException;

    String lockOrUnlockUser(Long id_user, Long updateBy, boolean enable)throws NotFoundException;
}
