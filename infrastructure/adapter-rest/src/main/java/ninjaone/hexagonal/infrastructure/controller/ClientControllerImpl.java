package ninjaone.hexagonal.infrastructure.controller;

import ninjaone.hexagonal.application.service.api.ClientService;
import ninjaone.hexagonal.application.service.api.ServiceCostService;
import ninjaone.hexagonal.domain.model.Client;
import ninjaone.hexagonal.domain.model.Contract;
import ninjaone.hexagonal.infrastructure.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/client")
public class ClientControllerImpl implements ClientController {

    private ClientService clientService;
    private ServiceCostService serviceCostService;

    @Autowired
    public ClientControllerImpl(ClientService clientService, ServiceCostService serviceCostService) {
        this.clientService = clientService;
        this.serviceCostService = serviceCostService;
    }

    @Override
    public ResponseEntity<Object> getTotalMontly(String identification) {

        try {
            var clientRegister = clientService.findByIdentification(identification);
            BigDecimal totalMontly = clientService.getTotalMontly(clientRegister);
            return ResponseHandler.generateResponse("Sum total montly", HttpStatus.OK, totalMontly);
        } catch (Exception erro) {
            return ResponseHandler.generateResponse("There was an error getting the customer's monthly total",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> addClient(Client client) {
        try {
            var servicesList= client.getServices();

            for (Contract contract : servicesList) {
                var serviceRegister = serviceCostService.findByServiceName(contract.getServiceName());

                if(serviceRegister == null) {
                    return ResponseHandler.generateResponse("Service " + contract.getServiceName() + " not found",
                            HttpStatus.NOT_FOUND, null);
                } else contract.setServiceCostId(serviceRegister.getServiceCostId());
            }

            clientService.addCliente(client);

            return ResponseHandler.generateResponse("Added Client", HttpStatus.CREATED, null);
        } catch (Exception error) {
            return ResponseHandler.generateResponse("There was an error adding the client",
                    HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}