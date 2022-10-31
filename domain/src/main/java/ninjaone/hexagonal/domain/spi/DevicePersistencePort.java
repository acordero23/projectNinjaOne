package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.Device;

public interface DevicePersistencePort {

    void addProduct(Device device);

    void removeDevice(Device device);

    void updateDevice(Device device);

    Device getDeviceById(Integer id);

    Device getDeviceBySystemName(String systemName);
}