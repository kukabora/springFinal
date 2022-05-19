package kz.iitu.itse1908.springfinalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "requests_log")
@JsonIgnoreProperties("version")
public class RequestsLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "createdat")
    private OffsetDateTime createdat;

    @Column(name = "remoteaddress", nullable = false)
    private String remoteaddress;

    @Column(name = "requesturl", nullable = false)
    private String requesturl;

    @Column(name = "controller", nullable = false)
    private String controller;

    @Column(name = "requestmethod", nullable = false)
    private String requestmethod;

    @Version
    @Column(name = "version")
    private long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OffsetDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(OffsetDateTime createdat) {
        this.createdat = createdat;
    }

    public String getRemoteaddress() {
        return remoteaddress;
    }

    public void setRemoteaddress(String remoteaddress) {
        this.remoteaddress = remoteaddress;
    }

    public String getRequesturl() {
        return requesturl;
    }

    public void setRequesturl(String requesturl) {
        this.requesturl = requesturl;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getRequestmethod() {
        return requestmethod;
    }

    public void setRequestmethod(String requestmethod) {
        this.requestmethod = requestmethod;
    }

}