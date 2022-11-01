package ninjaone.hexagonal.persistence.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer clientId;

    @Column(name = "client_mame")
    private String clientName;

    @Column(name = "client_identification")
    private String identification;

    public ClientEntity() {}

    public ClientEntity(String clientName, String identification) {
        super();
        this.clientName = clientName;
        this.identification = identification;
    }

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
}