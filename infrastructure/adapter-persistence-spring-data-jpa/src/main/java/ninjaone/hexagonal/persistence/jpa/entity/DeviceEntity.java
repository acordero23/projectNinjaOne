package ninjaone.hexagonal.persistence.jpa.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "devices")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer deviceId;

    @Column(name = "system_name")
    private String systemName;

    @Column
    private String type;

    @Column(columnDefinition="Decimal(18,2)")
    private BigDecimal cost;

    public DeviceEntity() {}

    public DeviceEntity(String systemName, String type, BigDecimal cost) {
        super();
        this.systemName = systemName;
        this.type = type;
        this.cost = cost;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}