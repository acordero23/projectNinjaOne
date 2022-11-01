package ninjaone.hexagonal.persistence.jpa.adapter;

import ninjaone.hexagonal.domain.model.Contract;
import ninjaone.hexagonal.domain.spi.ContractPersistencePort;
import ninjaone.hexagonal.persistence.jpa.entity.ContractEntity;
import ninjaone.hexagonal.persistence.jpa.repository.ContractRepository;

public class ContractSpringJpaAdapter implements ContractPersistencePort {

    private ContractRepository contractRepository;

    public ContractSpringJpaAdapter(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public void addContract(Contract contract) {
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setClientId(contract.getClientId());
        contractEntity.setServiceCostId(contract.getServiceCostId());
        contractEntity.setQuantity(contract.getQuantity());

        contractRepository.save(contractEntity);
    }
}