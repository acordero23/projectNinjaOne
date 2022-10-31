package ninjaone.hexagonal.infrastructure.controller;

import ninjaone.hexagonal.domain.model.Device;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DeviceController {

    @GetMapping("/device/{deviceId}")
    ResponseEntity<Object> getDeviceById(@PathVariable Integer deviceId);

    @PostMapping(value = "/device", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> addProduct(@RequestBody Device device);
}