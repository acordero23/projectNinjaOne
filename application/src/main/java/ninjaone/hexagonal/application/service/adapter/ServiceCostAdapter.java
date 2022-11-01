package ninjaone.hexagonal.application.service.adapter;

import ninjaone.hexagonal.application.service.api.ServiceCostService;
import ninjaone.hexagonal.domain.model.ServiceCost;
import ninjaone.hexagonal.domain.spi.ServiceCostPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceCostAdapter implements ServiceCostService {

    private ServiceCostPersistencePort serviceCostPersistencePort;

    @Autowired
    public ServiceCostAdapter(ServiceCostPersistencePort serviceCostPersistencePort) {
        this.serviceCostPersistencePort = serviceCostPersistencePort;
    }

    @Override
    public void addService(ServiceCost service) {
        serviceCostPersistencePort.addService(service);
    }

    @Override
    public void removeService(ServiceCost service) {
        serviceCostPersistencePort.removeService(service);
    }

    @Override
    public Integer findAllDevicesRelatedToAService(Integer serviceId) {
        return serviceCostPersistencePort.findAllDevicesRelatedToAService(serviceId);
    }

    @Override
    public ServiceCost findByServiceName(String serviceName) {
        return serviceCostPersistencePort.findByServiceName(serviceName);
    }
}