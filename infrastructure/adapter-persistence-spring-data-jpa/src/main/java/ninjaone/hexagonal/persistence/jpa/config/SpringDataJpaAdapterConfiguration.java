package ninjaone.hexagonal.persistence.jpa.config;

import ninjaone.hexagonal.domain.spi.DevicePersistencePort;
import ninjaone.hexagonal.persistence.jpa.adapter.DeviceSpringJpaAdapter;
import ninjaone.hexagonal.persistence.jpa.repository.DeviceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public DevicePersistencePort getDevicePersistencePort(DeviceRepository deviceRepository) {
        return new DeviceSpringJpaAdapter(deviceRepository);
    }
}
