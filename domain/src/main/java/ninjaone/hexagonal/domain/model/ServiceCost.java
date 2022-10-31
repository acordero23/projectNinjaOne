package ninjaone.hexagonal.domain.model;

import java.math.BigDecimal;

public class ServiceCost {
    private Integer serviceCostId;
    private String servicesName;
    private String deviceId;
    private BigDecimal cost;

    public Integer getServiceCostId() {
        return serviceCostId;
    }

    public void setServiceCostId(Integer serviceCostId) {
        this.serviceCostId = serviceCostId;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}