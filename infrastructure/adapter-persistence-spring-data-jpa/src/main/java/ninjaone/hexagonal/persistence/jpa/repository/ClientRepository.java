package ninjaone.hexagonal.persistence.jpa.repository;

import ninjaone.hexagonal.persistence.jpa.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByIdentification(String identificacion);
}