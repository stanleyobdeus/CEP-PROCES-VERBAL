package cep.gouv.ht.Repository;

import cep.gouv.ht.Models.UserRole;
import cep.gouv.ht.Models.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository  extends JpaRepository<UserRole, UserRoleId> {

}
