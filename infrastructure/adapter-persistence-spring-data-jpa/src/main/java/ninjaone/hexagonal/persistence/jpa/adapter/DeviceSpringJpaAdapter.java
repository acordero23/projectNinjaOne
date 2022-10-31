package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.Device;
import ninjaone.hexagonal.domain.spi.DevicePersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.DeviceEntity;
import ninjaone.hexagonal.persistence.jpa.repository.DeviceRepository;
import org.springframework.beans.BeanUtils;

public class DeviceSpringJpaAdapter implements DevicePersistencePort {
    private DeviceRepository deviceRepository;

    public DeviceSpringJpaAdapter(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public void addProduct(Device device) {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.setSystemName(device.getSystemName());
        deviceEntity.setType(device.getType());
        deviceEntity.setCost(device.getCost());

        deviceRepository.save(deviceEntity);
    }

    @Override
    public Device getDeviceById(Integer id) {
        DeviceEntity deviceEntity = deviceRepository.findByDeviceId(id);

        return this.getDevice(deviceEntity);
    }

    private Device getDevice(DeviceEntity deviceEntity) {
        if (deviceEntity == null) return null;

        Device device = new Device();
        BeanUtils.copyProperties(deviceEntity, device);

        return device;
    }
}