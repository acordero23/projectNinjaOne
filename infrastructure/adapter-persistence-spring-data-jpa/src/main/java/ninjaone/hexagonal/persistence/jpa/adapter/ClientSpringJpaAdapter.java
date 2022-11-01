package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.Client;
import ninjaone.hexagonal.domain.model.Contract;
import ninjaone.hexagonal.domain.spi.ClientPersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.ClientEntity;
import ninjaone.hexagonal.persistence.jpa.entity.ContractEntity;
import ninjaone.hexagonal.persistence.jpa.repository.ClientRepository;
import ninjaone.hexagonal.persistence.jpa.repository.ContractRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ClientSpringJpaAdapter implements ClientPersistencePort {

    private ClientRepository clientRepository;
    private ContractRepository contractRepository;

    public ClientSpringJpaAdapter(ClientRepository clientRepository, ContractRepository contractRepository) {
        this.clientRepository = clientRepository;
        this.contractRepository = contractRepository;
    }

    @Transactional
    @Override
    public void addCliente(Client client) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setClientName(client.getClientName());
        clientEntity.setIdentification(client.getIdentification());

        clientRepository.save(clientEntity);

        var clientRegister = clientRepository.findByIdentification(client.getIdentification());

        if(clientRegister != null) {
            List<Contract> servicesList = client.getServices();
            for (Contract contract : servicesList) {
                ContractEntity contractEntity = new ContractEntity();
                contractEntity.setClientId(clientRegister.getClientId());
                contractEntity.setServiceCostId(contract.getServiceCostId());
                contractEntity.setQuantity(contract.getQuantity());

                contractRepository.save(contractEntity);
            }
        }
    }
}