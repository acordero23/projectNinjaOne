package ninjaone.hexagonal.infrastructure.controller;

import ninjaone.hexagonal.domain.model.ServiceCost;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ServiceCostController {

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> addService(@RequestBody ServiceCost service);

    @DeleteMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> removeService(@RequestBody ServiceCost service);
}