package ninjaone.hexagonal.application.service.adapter;

import ninjaone.hexagonal.application.service.api.DeviceService;
import ninjaone.hexagonal.domain.model.Device;
import ninjaone.hexagonal.domain.spi.DevicePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeviceServiceAdapter implements DeviceService {

    private DevicePersistencePort devicePersistencePort;

    @Autowired
    public DeviceServiceAdapter(DevicePersistencePort devicePersistencePort) {
        this.devicePersistencePort = devicePersistencePort;
    }

    @Override
    public void addProduct(Device device) {
        devicePersistencePort.addProduct(device);
    }

    @Override
    public void removeDevice(Device device) {
        devicePersistencePort.removeDevice(device);
    }

    @Override
    public void updateDevice(Device device) {
        devicePersistencePort.updateDevice(device);
    }

    @Override
    public Device getDeviceById(Integer id) {
        return devicePersistencePort.getDeviceById(id);
    }

    @Override
    public Device getDeviceBySystemName(String systemName) {
        return devicePersistencePort.getDeviceBySystemName(systemName);
    }
}
