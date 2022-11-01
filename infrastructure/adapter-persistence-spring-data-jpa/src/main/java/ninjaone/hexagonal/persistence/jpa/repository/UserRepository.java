package ninjaone.hexagonal.persistence.jpa.repository;

import ninjaone.hexagonal.persistence.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findOneByEmail(String email);
}