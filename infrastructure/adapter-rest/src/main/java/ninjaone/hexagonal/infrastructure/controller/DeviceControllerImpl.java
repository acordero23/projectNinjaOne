package ninjaone.hexagonal.infrastructure.controller;

import ninjaone.hexagonal.application.service.api.DeviceService;
import ninjaone.hexagonal.application.service.api.ServiceCostService;
import ninjaone.hexagonal.domain.model.Device;
import ninjaone.hexagonal.infrastructure.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceControllerImpl implements DeviceController{

    private ServiceCostService serviceCostService;
    private DeviceService deviceService;

    @Autowired
    public DeviceControllerImpl(DeviceService deviceService, ServiceCostService serviceCostService) {
        this.deviceService = deviceService;
        this.serviceCostService = serviceCostService;
    }

    @Override
    public ResponseEntity<Object> getDeviceById(Integer deviceId) {
        try {
            var device = deviceService.getDeviceById(deviceId);

            if(device == null)
                return ResponseHandler.generateResponse("Device not found", HttpStatus.NOT_FOUND, null);

            return ResponseHandler.generateResponse("Device found", HttpStatus.OK, deviceService.getDeviceById(deviceId));
        } catch (Exception error) {
            return ResponseHandler.generateResponse("There was an error getting the device",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> addDevice(Device device) {
        try {
            var deviceRegister = deviceService.getDeviceBySystemName(device.getSystemName());

            if(deviceRegister != null)
                return ResponseHandler.generateResponse("Device already exists", HttpStatus.CONFLICT, null);

            deviceService.addDevice(device);

            return ResponseHandler.generateResponse("Added Device", HttpStatus.CREATED, null);
        } catch (Exception error) {
            return ResponseHandler.generateResponse("There was an error adding the device",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> removeDevice(Device device) {
        try {
            var cantDevicesRelatedToAService = serviceCostService.findAllDevicesRelatedToAService(device.getDeviceId());

            if(cantDevicesRelatedToAService != 0)
                return ResponseHandler.generateResponse("Service related device", HttpStatus.BAD_REQUEST, null);

            var deviceRegister = deviceService.getDeviceById(device.getDeviceId());

            if(deviceRegister == null)
                return ResponseHandler.generateResponse("Device not found", HttpStatus.NOT_FOUND, null);

            deviceService.removeDevice(device);

            return ResponseHandler.generateResponse("Removed Device", HttpStatus.OK, null);
        } catch (Exception error) {
            return ResponseHandler.generateResponse("There was an error removing the device",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> updateDevice(Device device) {
        try {
            var deviceRegister = deviceService.getDeviceById(device.getDeviceId());

            if(deviceRegister == null)
                return ResponseHandler.generateResponse("Device not found", HttpStatus.NOT_FOUND, null);

            deviceService.updateDevice(device);

            return ResponseHandler.generateResponse("Updated Device", HttpStatus.OK, null);
        } catch (Exception error) {
            return ResponseHandler.generateResponse("There was an error removing the device",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}