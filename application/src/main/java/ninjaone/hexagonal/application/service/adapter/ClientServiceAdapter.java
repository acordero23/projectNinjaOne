package ninjaone.hexagonal.application.service.adapter;

import ninjaone.hexagonal.application.service.api.ClientService;
import ninjaone.hexagonal.domain.model.Client;
import ninjaone.hexagonal.domain.spi.ClientPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ClientServiceAdapter implements ClientService {

    private ClientPersistencePort clientPersistencePort;

    @Autowired
    public ClientServiceAdapter(ClientPersistencePort clientPersistencePort) {
        this.clientPersistencePort = clientPersistencePort;
    }

    @Override
    public void addCliente(Client client) {
        clientPersistencePort.addCliente(client);
    }

    @Override
    public Client findByIdentification(String identification) {
        return clientPersistencePort.findByIdentification(identification);
    }

    @Override
    public BigDecimal getTotalMontly(Client client) {
        return clientPersistencePort.getTotalMontly(client);
    }
}