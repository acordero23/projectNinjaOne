package ninjaone.hexagonal.domain.model;

import java.math.BigDecimal;

public class Contract {
    private Integer contractId;
    private String clientId;
    private Integer serviceCostId;
    private String serviceName;
    private BigDecimal quantity;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getServiceCostId() {
        return serviceCostId;
    }

    public void setServiceCostId(Integer serviceCostId) {
        this.serviceCostId = serviceCostId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}