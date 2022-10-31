package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.Device;

public interface DevicePersistencePort {

    void addProduct(Device device);

    Device getDeviceById(Integer id);
}