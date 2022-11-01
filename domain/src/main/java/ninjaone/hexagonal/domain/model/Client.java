package ninjaone.hexagonal.domain.model;

import java.util.List;

public class Client {
    private Integer clientId;
    private String clientName;
    private String identification;
    private List<Contract> services;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public List<Contract> getServices() {
        return services;
    }

    public void setServices(List<Contract> services) {
        this.services = services;
    }
}