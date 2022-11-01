package ninjaone.hexagonal.domain.spi;

import ninjaone.hexagonal.domain.model.Contract;

public interface ContractPersistencePort {

    void addContract(Contract contract);
}