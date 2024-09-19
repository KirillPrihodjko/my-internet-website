package website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import website.entity.user.Role;
import website.entity.user.UserEntity;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByIdAndDateOfBirth(Integer id, String dateOfBirth);

    UserEntity findUserByFirstName(String firstName);

    UserEntity findUserByLastName(String lastName);

    UserEntity findUserByPassword(String password);

    UserEntity findUserByEmail(String email);

    UserEntity findUserByDateOfBirth(String dateOfBirth);

    UserEntity findUserByRoles(Set<Role> roles);
}
