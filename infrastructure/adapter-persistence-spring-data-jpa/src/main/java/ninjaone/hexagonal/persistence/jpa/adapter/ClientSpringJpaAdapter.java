package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.Client;
import ninjaone.hexagonal.domain.spi.ClientPersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.ClientEntity;
import ninjaone.hexagonal.persistence.jpa.repository.ClientRepository;

public class ClientSpringJpaAdapter implements ClientPersistencePort {

    private ClientRepository clientRepository;

    public ClientSpringJpaAdapter(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void addCliente(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientName(client.getClientName());
        clientEntity.setIdentification(client.getIdentification());

        clientRepository.save(clientEntity);
    }
}