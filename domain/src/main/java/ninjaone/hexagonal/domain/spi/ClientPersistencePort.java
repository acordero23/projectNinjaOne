package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.Client;

import java.math.BigDecimal;

public interface ClientPersistencePort {

    void addCliente(Client client);

    Client findByIdentification(String identification);

    BigDecimal getTotalMontly(Client client);
}