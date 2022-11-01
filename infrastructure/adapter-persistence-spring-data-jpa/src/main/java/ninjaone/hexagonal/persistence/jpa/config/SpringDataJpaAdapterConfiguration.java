package ninjaone.hexagonal.persistence.jpa.config;

import ninjaone.hexagonal.domain.spi.*;
import ninjaone.hexagonal.persistence.jpa.adapter.*;
import ninjaone.hexagonal.persistence.jpa.repository.*;
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

    @Bean
    public UserPersistencePort getUserPersistencePort(UserRepository userRepository) {
        return new UserSpringJpaAdapter(userRepository);
    }
}