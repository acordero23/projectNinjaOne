package ninjaone.hexagonal.persistence.jpa.config;

import ninjaone.hexagonal.domain.spi.ClientPersistencePort;
import ninjaone.hexagonal.domain.spi.ContractPersistencePort;
import ninjaone.hexagonal.domain.spi.DevicePersistencePort;
import ninjaone.hexagonal.domain.spi.ServiceCostPersistencePort;
import ninjaone.hexagonal.persistence.jpa.adapter.ClientSpringJpaAdapter;
import ninjaone.hexagonal.persistence.jpa.adapter.ContractSpringJpaAdapter;
import ninjaone.hexagonal.persistence.jpa.adapter.DeviceSpringJpaAdapter;
import ninjaone.hexagonal.persistence.jpa.adapter.ServiceCostSpringJpaAdapter;
import ninjaone.hexagonal.persistence.jpa.repository.ClientRepository;
import ninjaone.hexagonal.persistence.jpa.repository.ContractRepository;
import ninjaone.hexagonal.persistence.jpa.repository.DeviceRepository;
import ninjaone.hexagonal.persistence.jpa.repository.ServiceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public DevicePersistencePort getDevicePersistencePort(DeviceRepository deviceRepository) {
        return new DeviceSpringJpaAdapter(deviceRepository);
    }

    @Bean
    public ServiceCostPersistencePort getServiceCostPersistencePort(ServiceRepository serviceRepository) {
        return new ServiceCostSpringJpaAdapter(serviceRepository);
    }

    @Bean
    public ClientPersistencePort getClientPersistencePort(ClientRepository clientRepository, ContractRepository contractRepository) {
        return new ClientSpringJpaAdapter(clientRepository, contractRepository);
    }

    @Bean
    public ContractPersistencePort getContractPersistencePort(ContractRepository contractRepository) {
        return new ContractSpringJpaAdapter(contractRepository);
    }
}