package ninjaone.hexagonal.infrastructure.controller;

import ninjaone.hexagonal.domain.model.Device;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DeviceController {

    @GetMapping("/{deviceId}")
    ResponseEntity<Object> getDeviceById(@PathVariable Integer deviceId);

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> addDevice(@RequestBody Device device);

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> removeDevice(@RequestBody Device device);

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> updateDevice(@RequestBody Device device);
}