package cep.gouv.ht.Services;


/*
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    ImageRepository imageRepository;


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public UserBean SaveUser(UserBean userBean, MultipartFile file) throws AlreadyExistdException, IOException {
        return null;
    }

    @Override
    public List<UserBean> FindAllUser() {
        return null;
    }

    @Override
    public String DeleteUser(String id) throws NotFoundException {

        if (!userRepository.existsById(Long.valueOf(id))) {
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        }
        userRepository.deleteById(Long.valueOf(id));
        return Constante.USER_DELETE;
    }

    @Override
    public String UpdateUser(UserBean userBean) throws NotFoundException, AlreadyExistdException {
        if (userBean.getId() == null) {

        }

        if (!userRepository.existsById(Long.valueOf(userBean.getId()))) {
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        }
        User entity = userRepository.getUserByUserNameAndIdOrganisation("", Long.valueOf("2"));
        if (entity != null)
            throw new NotFoundException("Username deja attribue a une autre utilisateur");

        modelMapper = new ModelMapper();
        userRepository.updateUser(userBean.getUsername(), encoder.encode(userBean.getPassword()), userBean.getId(), LocalDateTime.now(), Long.valueOf("2"));
        UserBean bean = userBean;
        bean.setUpdateDate(LocalDate.now());
        return Constante.USER_UPDATE_SUCCESSFULLY;
    }

    @Override
    public String AddRoleToUser(String id_user, String id_role) throws NotFoundException, AlreadyExistdException {
        if (!userRepository.existsById(Long.valueOf(id_user))) {
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        }
        if (!roleRepository.existsById(Integer.parseInt(id_role))) {
            throw new NotFoundException(Constante.ROLE_NOT_FOUND);
        }
        if (userRoleRepository.existsById(new UserRoleId(Long.valueOf(id_user), Integer.parseInt(id_role)))) {
            throw new AlreadyExistdException(Constante.ROLE_ALREADY_ASSIGNE);
        }
        userRoleRepository.save(new UserRole(Long.valueOf(id_user), Integer.parseInt(id_role)));
        return Constante.ROLE_ADD_TO_USER;
    }

    @Override
    public String RemoveRoleToUser(String id_user, String id_role) throws NotFoundException {
        if (!userRepository.existsById(Long.valueOf(id_user))) {
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        }
        if (!roleRepository.existsById(Integer.parseInt(id_role))) {
            throw new NotFoundException(Constante.ROLE_NOT_FOUND);
        }
        if (!userRoleRepository.existsById(new UserRoleId(Long.valueOf(id_user), Integer.parseInt(id_role)))) {
            throw new NotFoundException(Constante.ROLE_NOT_ASSIGNE);
        }
        userRoleRepository.delete(new UserRole(Long.valueOf(id_user), Integer.parseInt(id_role)));
        return Constante.ROLE_REMOVE_TO_USER;
    }

    @Override
    public UserBean getUserByUsername(String username) throws NotFoundException {
        return null;
    }

    @Override
    public RoleBean CreateRole(RoleBean roleBean) throws AlreadyExistdException {
        if (roleRepository.getRoleByname(roleBean.getName()) != null) {
            throw new AlreadyExistdException(Constante.ROLE_ALREADY_EXIST);
        }

        modelMapper = new ModelMapper();
        Role role = modelMapper.map(roleBean, Role.class);
        role.setCreateDate(LocalDateTime.now());
        Role entity = roleRepository.save(role);
        return modelMapper.map(entity, RoleBean.class);
    }

    @Override
    public UserBean getUserById(String id_user) throws NotFoundException {
       */
/* modelMapper = new ModelMapper();
        if (!userRepository.existsById(Long.valueOf(id_user))) {
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        }
        User user=userRepository.getUserByIdUser(Long.valueOf(id_user));
        UserBean newUserbean = modelMapper.map(user, UserBean.class);
        Organisation organisation=organisationRepository.getOrganisationByIdUser(user.getId());
        newUserbean.setOrganisationBean(modelMapper.map(organisation, OrganisationBean.class));*//*

        return null;
    }

    @Override
    public UserBean getUserByUserNameAndIdOrganisation(String user_name, Long code_organisation) throws NotFoundException {
        User entity = userRepository.getUserByUserNameAndIdOrganisation(user_name.trim(), code_organisation);
        if (entity == null)
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        modelMapper = new ModelMapper();
        OperatorBean operatorBean = modelMapper.map(entity.getOperator(), OperatorBean.class);
        UserBean beanUser = modelMapper.map(entity, UserBean.class);
        beanUser.setOperatorBean(operatorBean);
        return beanUser;
    }

    @Override
    public UserBean getUserByUserNameAndCodeOrganisation(String username, String code_organisation) throws NotFoundException {
        User entity = userRepository.getUserByUserNameAndCodeOrganisation(username.trim(), code_organisation);
        if (entity == null)
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        modelMapper = new ModelMapper();
        OperatorBean operatorBean = modelMapper.map(entity.getOperator(), OperatorBean.class);
        UserBean beanUser = modelMapper.map(entity, UserBean.class);
        beanUser.setOperatorBean(operatorBean);
        return beanUser;
    }


    @Override
    public ImagesBean getImageUser(String username, Long code_organisation) throws NotFoundException {
        User entity = userRepository.getUserByUserNameAndIdOrganisation(username.trim(), code_organisation);
        if (entity == null)
            throw new NotFoundException(Constante.USER_NOT_FOUND);
        modelMapper = new ModelMapper();
        Images images = entity.getOperator().getImages();
        ImagesBean bean = modelMapper.map(images, ImagesBean.class);
        return bean;
    }

    @Override
    public Response changePassword(String username, Long id_organisation, String old_password, String new_password) throws NotFoundException {
        User entity = userRepository.getUserByUserNameAndIdOrganisation(username.trim(), id_organisation);

        if (new_password == null || new_password.trim().isEmpty())
            return new Response(Constante.MODE_PASS_IVALID, "400");
        if (entity == null)
            return new Response(Constante.USER_NOT_FOUND, "404");
        if (!encoder.matches(old_password, entity.getPassword())) {
            return new Response(Constante.PASSWORD_NOT_MATCH_MESSAGE, "400");
        }
        userRepository.changePassword(username, entity.getId(), encoder.encode(new_password), LocalDateTime.now());
        return new Response(Constante.CHANGE_PASSWORD_MESSAGE, "200");
    }

    @Override
    public Response lockOrUnlockUser(Long id_user, Long updateBy, boolean enable) throws NotFoundException {
        if (!userRepository.existsById(Long.valueOf(id_user)))
            return new Response(Constante.USER_NOT_FOUND, "404");
        userRepository.lockOrUnlockUser(id_user, LocalDateTime.now(), updateBy, enable);
        return new Response(enable ? Constante.USER_UNLOCK : Constante.USER_LOCK, "200");
    }

}
*/
