package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.ServiceCost;

public interface ServiceCostPersistencePort {
    void addService(ServiceCost device);

    void removeService(ServiceCost device);

    Integer findAllDevicesRelatedToAService(Integer serviceId);
}