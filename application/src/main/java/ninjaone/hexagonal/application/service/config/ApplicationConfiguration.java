package ninjaone.hexagonal.application.service.config;

import ninjaone.hexagonal.application.service.adapter.DeviceServiceAdapter;
import ninjaone.hexagonal.application.service.api.DeviceService;
import ninjaone.hexagonal.domain.spi.DevicePersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public DeviceService getDeviceService(DevicePersistencePort devicePersistencePort) {
        return new DeviceServiceAdapter(devicePersistencePort);
    }
}
