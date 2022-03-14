package cep.gouv.ht.Repository;


import cep.gouv.ht.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

   @Query("SELECT u FROM User u WHERE u.username=:username")
    User getUserByUsername(@Param("username") String username);

    /* @Query("SELECT u FROM User u WHERE u.id=:id")
    User getUserByIdUser(@Param("id") Long id);

    @Modifying
    @Query("UPDATE User u SET u.username = :username,u.password=:password,u.updateDate=:updateDate,u.updateBy=:id_current_user WHERE u.id = :id")
    public Integer updateUser(@Param("username") String username, @Param("password") String password, @Param("id") Long id, @Param("updateDate") LocalDateTime updateDate, @Param("id_current_user") Long id_current_user);


    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password=:new_password, u.updateDate=:update_date WHERE u.username = :username AND u.id=:id")
    public Integer changePassword(@Param("username") String username, @Param("id") Long id, @Param("new_password") String new_password, @Param("update_date") LocalDateTime update_date);


    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.enabled=:enabled, u.updateDate=:update_date,u.updateBy=:updateBy WHERE u.id=:id")
    public Integer lockOrUnlockUser(@Param("id") Long id,
                                    @Param("update_date") LocalDateTime update_date,
                                    @Param("updateBy") Long updateBy,
                                    @Param("enabled") boolean enabled);*/
}
