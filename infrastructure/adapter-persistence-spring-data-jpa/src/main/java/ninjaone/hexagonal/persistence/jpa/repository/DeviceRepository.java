package ninjaone.hexagonal.persistence.jpa.repository;

import ninjaone.hexagonal.persistence.jpa.entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<DeviceEntity, Integer> {

    DeviceEntity findByDeviceId(Integer id);
}