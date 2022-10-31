package ninjaone.hexagonal.application.service.api;

import ninjaone.hexagonal.domain.model.Device;

public interface DeviceService {

    void addProduct(Device device);

    void removeDevice(Device device);

    void updateDevice(Device device);

    Device getDeviceById(Integer id);

    Device getDeviceBySystemName(String systemName);
}