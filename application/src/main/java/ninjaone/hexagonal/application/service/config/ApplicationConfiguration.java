package ninjaone.hexagonal.application.service.config;

import ninjaone.hexagonal.application.service.adapter.*;
import ninjaone.hexagonal.application.service.api.*;
import ninjaone.hexagonal.domain.spi.*;
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

    @Bean
    public ClientService getClientService(ClientPersistencePort clientPersistencePort) {
        return new ClientServiceAdapter(clientPersistencePort);
    }

    @Bean
    public ContractService getContractService(ContractPersistencePort contractPersistencePort) {
        return new ContractServiceAdapter(contractPersistencePort);
    }

    @Bean
    public UserService getUserService(UserPersistencePort userPersistencePort) {
        return new UserServiceAdapter(userPersistencePort);
    }
}