package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.Client;

public interface ClientPersistencePort {

    void addCliente(Client client);
}