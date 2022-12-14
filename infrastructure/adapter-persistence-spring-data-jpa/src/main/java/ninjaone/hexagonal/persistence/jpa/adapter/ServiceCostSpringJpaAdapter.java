package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.ServiceCost;
import ninjaone.hexagonal.domain.spi.ServiceCostPersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.ServiceEntity;
import ninjaone.hexagonal.persistence.jpa.repository.ServiceRepository;
import org.springframework.beans.BeanUtils;

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
    public void removeService(ServiceCost service) {
        ServiceEntity serviceEntity = new ServiceEntity();
        BeanUtils.copyProperties(service, serviceEntity);

        serviceRepository.delete(serviceEntity);
    }

    @Override
    public Integer findAllDevicesRelatedToAService(Integer deviceId) {
        Query query = entityManager.createNativeQuery(
                "SELECT SERVICES_COST.* FROM DEVICES INNER JOIN SERVICES_COST ON DEVICES.ID = SERVICES_COST.DEVICE_ID WHERE DEVICE_ID = ? LIMIT 1");
        query.setParameter(1, deviceId);
        var result = query.getResultList();

        return result.size();
    }

    @Override
    public ServiceCost findByServiceName(String serviceName) {
        ServiceEntity serviceEntity = serviceRepository.findByServiceName(serviceName);

        if (serviceEntity == null) return null;

        return getServiceCost(serviceEntity);
    }

    @Override
    public ServiceCost findByServiceCostId(Integer serviceId) {
        ServiceEntity serviceEntity = serviceRepository.findByServiceCostId(serviceId);

        if (serviceEntity == null) return null;

        return getServiceCost(serviceEntity);
    }

    private ServiceCost getServiceCost(ServiceEntity serviceEntity) {
        ServiceCost serviceCost = new ServiceCost();
        serviceCost.setServiceCostId(serviceEntity.getServiceCostId());
        serviceCost.setServiceName(serviceEntity.getServiceName());
        serviceCost.setDeviceId(serviceEntity.getDeviceId());
        serviceCost.setCost(serviceEntity.getCost());

        return serviceCost;
    }
}