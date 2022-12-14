package ninjaone.hexagonal.domain.model;

import java.math.BigDecimal;

public class ServiceCost {
    private Integer serviceCostId;
    private String serviceName;
    private Integer deviceId;
    private String deviceName;
    private BigDecimal cost;

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

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}