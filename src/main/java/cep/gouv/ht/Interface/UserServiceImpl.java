package cep.gouv.ht.Interface;


import cep.gouv.ht.Bean.RoleBean;
import cep.gouv.ht.Bean.UserBean;
import cep.gouv.ht.Exception.AlreadyExistdException;
import cep.gouv.ht.Exception.NotFoundException;
import cep.gouv.ht.Models.Images;
import cep.gouv.ht.Models.User;
import cep.gouv.ht.Repository.ImageRepository;
import cep.gouv.ht.Repository.UserRepository;
import cep.gouv.ht.Utils.Constante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageRepository imageRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    PasswordEncoder encoder;


    @Override
    public UserBean saveUser(UserBean userBean) throws AlreadyExistdException {
        try {
            if (userRepository.getUserByUsername(userBean.getUsername()) != null) {
                throw new AlreadyExistdException(Constante.USER_ALREADY_EXIST);
            }
            Images image=imageRepository.save(new Images(userBean.getImage()));
            userBean.setPassword(encoder.encode(userBean.getPassword()));
            userBean.setCreateDate(LocalDateTime.now());
            User user = modelMapper.map(userBean, User.class);
            user.setId_image(image.getId());
            user.setEnabled(true);
            UserBean userBean1 = modelMapper.map(userRepository.save(user), UserBean.class);
            return userBean1;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    public List<UserBean> findAllUser() {
        return null;
    }

    @Override
    public String deleteUser(String id) throws NotFoundException {
        return null;
    }

    @Override
    public String updateUser(UserBean userBean) throws NotFoundException, AlreadyExistdException {
        return null;
    }

    @Override
    public String addRoleToUser(String id_user, String id_role) throws NotFoundException, AlreadyExistdException {
        return null;
    }

    @Override
    public String removeRoleToUser(String id_user, String id_role) throws NotFoundException, AlreadyExistdException {
        return null;
    }

    @Override
    public UserBean getUserByUsername(String user_name) throws NotFoundException {
        User entity = userRepository.getUserByUsername(user_name);
        if (entity == null)
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        modelMapper = new ModelMapper();
        UserBean userBean = modelMapper.map(entity, UserBean.class);
        return userBean;
    }

    @Override
    public RoleBean createRole(RoleBean roleMBean) throws AlreadyExistdException {
        return null;
    }

    @Override
    public UserBean getUserById(String id_user) throws NotFoundException {
        return null;
    }

    @Override
    public String changePassword(String username, Long id_organisation, String old_password, String new_password) throws NotFoundException {
        return null;
    }

    @Override
    public String lockOrUnlockUser(Long id_user, Long updateBy, boolean enable) throws NotFoundException {
        return null;
    }
}
