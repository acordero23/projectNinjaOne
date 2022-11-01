package ninjaone.hexagonal.application.service.config;

import ninjaone.hexagonal.application.service.adapter.DeviceServiceAdapter;
import ninjaone.hexagonal.application.service.adapter.ServiceCostAdapter;
import ninjaone.hexagonal.application.service.api.DeviceService;
import ninjaone.hexagonal.application.service.api.ServiceCostService;
import ninjaone.hexagonal.domain.spi.DevicePersistencePort;
import ninjaone.hexagonal.domain.spi.ServiceCostPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public DeviceService getDeviceService(DevicePersistencePort devicePersistencePort) {
        return new DeviceServiceAdapter(devicePersistencePort);
    }

    @Bean
    public ServiceCostService getServiceCostService(ServiceCostPersistencePort serviceCostPersistencePort) {
        return new ServiceCostAdapter(serviceCostPersistencePort);
    }
}