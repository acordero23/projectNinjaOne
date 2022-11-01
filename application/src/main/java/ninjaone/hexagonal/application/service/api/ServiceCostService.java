package ninjaone.hexagonal.application.service.api;

import ninjaone.hexagonal.domain.model.ServiceCost;

public interface ServiceCostService {

    void addService(ServiceCost service);

    void removeService(ServiceCost service);

    Integer findAllDevicesRelatedToAService(Integer deviceId);

    ServiceCost findByServiceName(String serviceName);
}