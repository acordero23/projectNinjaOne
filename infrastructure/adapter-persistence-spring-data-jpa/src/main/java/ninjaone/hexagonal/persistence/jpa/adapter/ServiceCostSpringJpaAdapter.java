package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.ServiceCost;
import ninjaone.hexagonal.domain.spi.ServiceCostPersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.ServiceEntity;
import ninjaone.hexagonal.persistence.jpa.repository.ServiceRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class ServiceCostSpringJpaAdapter  implements ServiceCostPersistencePort {

    @PersistenceContext
    private EntityManager entityManager;

    private ServiceRepository serviceRepository;

    public ServiceCostSpringJpaAdapter(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public void addService(ServiceCost service) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setServiceName(service.getServiceName());
        serviceEntity.setDeviceId(service.getDeviceId());
        serviceEntity.setCost(service.getCost());

        serviceRepository.save(serviceEntity);
    }

    @Override
    public void removeService(ServiceCost device) {

    }

    @Override
    public Integer findAllDevicesRelatedToAService(Integer deviceId) {
        Query query = entityManager.createNativeQuery(
                "SELECT SERVICES_COST.* FROM DEVICES INNER JOIN SERVICES_COST ON DEVICES.ID = SERVICES_COST.DEVICE_ID WHERE DEVICE_ID = ? LIMIT 1");
        query.setParameter(1, deviceId);
        var result = query.getResultList();

        return result.size();
    }
}