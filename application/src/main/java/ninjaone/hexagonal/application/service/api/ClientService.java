package ninjaone.hexagonal.application.service.api;

import ninjaone.hexagonal.domain.model.Client;

import java.math.BigDecimal;

public interface ClientService {

    void addCliente(Client client);

    Client findByIdentification(String identification);

    BigDecimal getTotalMontly(Client client);
}
