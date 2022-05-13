package kz.iitu.itse1908.springfinalproject.Entities;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "creatorid", nullable = false)
    private User creatorid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recieverid", nullable = false)
    private User recieverid;

    @Column(name = "text", nullable = false)
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(User creatorid) {
        this.creatorid = creatorid;
    }

    public User getRecieverid() {
        return recieverid;
    }

    public void setRecieverid(User recieverid) {
        this.recieverid = recieverid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}