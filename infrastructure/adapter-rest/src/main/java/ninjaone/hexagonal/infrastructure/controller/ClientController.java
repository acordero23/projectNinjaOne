package ninjaone.hexagonal.infrastructure.controller;

import ninjaone.hexagonal.domain.model.Client;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClientController {
    @GetMapping("/totalMontly/{identification}")
    ResponseEntity<Object> getTotalMontly(@PathVariable String identification);

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> addClient(@RequestBody Client client);
}