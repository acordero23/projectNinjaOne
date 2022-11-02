package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.ServiceCost;

public interface ServiceCostPersistencePort {
    void addService(ServiceCost service);

    void removeService(ServiceCost service);

    Integer findAllDevicesRelatedToAService(Integer serviceId);

    ServiceCost findByServiceName(String serviceName);

    ServiceCost findByServiceCostId(Integer serviceId);
}