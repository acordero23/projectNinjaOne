package ninjaone.hexagonal.infrastructure.controller;

import ninjaone.hexagonal.application.service.api.DeviceService;
import ninjaone.hexagonal.application.service.api.ServiceCostService;
import ninjaone.hexagonal.domain.model.ServiceCost;
import ninjaone.hexagonal.infrastructure.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceCostControllerImpl implements ServiceCostController{

    private DeviceService deviceService;
    private ServiceCostService serviceCostService;

    @Autowired
    public ServiceCostControllerImpl(DeviceService deviceService, ServiceCostService serviceCostService) {
        this.deviceService = deviceService;
        this.serviceCostService = serviceCostService;
    }

    @Override
    public ResponseEntity<Object> addService(ServiceCost service) {
        try {
            var deviceRegister = deviceService.getDeviceBySystemName(service.getDeviceName());
            if(deviceRegister == null)
                return ResponseHandler.generateResponse("Device specifid not found", HttpStatus.NOT_FOUND, null);

            var serviceRegister = serviceCostService.findByServiceName(service.getServiceName());
            if(serviceRegister != null)
                return ResponseHandler.generateResponse("Service already exists", HttpStatus.CONFLICT, null);

            service.setDeviceId(deviceRegister.getDeviceId());

            serviceCostService.addService(service);

            return ResponseHandler.generateResponse("Added Service", HttpStatus.CREATED, null);
        } catch (Exception error) {
            return ResponseHandler.generateResponse("There was an error adding the service",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> removeService(ServiceCost service) {
        return null;
    }
}