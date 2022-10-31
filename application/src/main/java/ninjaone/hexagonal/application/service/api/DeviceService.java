package ninjaone.hexagonal.application.service.api;

import ninjaone.hexagonal.domain.model.Device;

public interface DeviceService {

    void addProduct(Device device);

    Device getDeviceById(Integer id);
}