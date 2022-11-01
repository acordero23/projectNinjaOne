package ninjaone.hexagonal.persistence.jpa.repository;

import ninjaone.hexagonal.persistence.jpa.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Integer> {
}