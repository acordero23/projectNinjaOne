package ninjaone.hexagonal.persistence.jpa.repository;

import ninjaone.hexagonal.persistence.jpa.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<ContractEntity, Integer> {
}