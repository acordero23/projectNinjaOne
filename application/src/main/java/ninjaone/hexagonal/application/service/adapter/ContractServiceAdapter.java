package ninjaone.hexagonal.application.service.adapter;

import ninjaone.hexagonal.application.service.api.ContractService;
import ninjaone.hexagonal.domain.model.Contract;
import ninjaone.hexagonal.domain.spi.ContractPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

public class ContractServiceAdapter implements ContractService {

    private ContractPersistencePort contractPersistencePort;

    @Autowired
    public ContractServiceAdapter(ContractPersistencePort contractPersistencePort) {
        this.contractPersistencePort = contractPersistencePort;
    }

    @Override
    public void addContract(Contract contract) {
        contractPersistencePort.addContract(contract);
    }
}