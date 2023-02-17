package website.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import website.entity.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByIdAndDateOfBirth(Integer id, String dateOfBirth);
    UserEntity findPersonEntityByFirstName(String name);
}
