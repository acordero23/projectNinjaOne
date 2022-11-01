package ninjaone.hexagonal.persistence.jpa.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "services_cost")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer serviceCostId;

    @Column(name = "service_name")
    private String serviceName;

    @Column(name = "device_id")
    private Integer deviceId;

    @Column(columnDefinition="Decimal(18,2)")
    private BigDecimal cost;

    public ServiceEntity() {}

    public ServiceEntity(String serviceName, BigDecimal cost) {
        super();
        this.serviceName = serviceName;
        this.cost = cost;
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

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}