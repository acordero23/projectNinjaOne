package ninjaone.hexagonal.persistence.jpa.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "contract")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer contractId;

    @Column(name = "client_id")
    private Integer clientId;

    @Column(name = "service_cost_id")
    private Integer serviceCostId;

    @Column(name = "quantity")
    private BigDecimal quantity;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getServiceCostId() {
        return serviceCostId;
    }

    public void setServiceCostId(Integer serviceCostId) {
        this.serviceCostId = serviceCostId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}