package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.Client;
import ninjaone.hexagonal.domain.model.Contract;
import ninjaone.hexagonal.domain.spi.ClientPersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.ClientEntity;
import ninjaone.hexagonal.persistence.jpa.entity.ContractEntity;
import ninjaone.hexagonal.persistence.jpa.repository.ClientRepository;
import ninjaone.hexagonal.persistence.jpa.repository.ContractRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

public class ClientSpringJpaAdapter implements ClientPersistencePort {

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    public Client findByIdentification(String identificacion) {
        ClientEntity clientEntity = clientRepository.findByIdentification(identificacion);

        if (clientEntity == null) return null;

        Client client = new Client();
        client.setClientId(clientEntity.getClientId());
        client.setClientName(clientEntity.getClientName());
        client.setIdentification(clientEntity.getIdentification());

        return client;
    }

    @Override
    public BigDecimal getTotalMontly(Client client) {
        Query query = entityManager.createNativeQuery("SELECT SUM(CONTRACT.QUANTITY * COALESCE(SERVICES_COST.COST, DEVICES.COST)) as SUM " +
                "FROM CONTRACT " +
                "INNER JOIN SERVICES_COST ON CONTRACT.SERVICE_COST_ID = SERVICES_COST.ID " +
                "INNER JOIN DEVICES ON SERVICES_COST.DEVICE_ID = DEVICES.ID " +
                "WHERE CONTRACT.CLIENT_ID = ?");
        query.setParameter(1, client.getClientId());

        var result = query.getResultList();

        return new BigDecimal(result.get(0).toString());
    }
}