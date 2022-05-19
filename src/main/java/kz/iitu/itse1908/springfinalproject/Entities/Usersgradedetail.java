package kz.iitu.itse1908.springfinalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "usersgradedetails")
@JsonIgnoreProperties("userid")
public class Usersgradedetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private User userid;

    @Column(name = "gpa")
    private Double gpa;

    @Column(name = "readyassessments")
    private Integer readyassessments;

    @Column(name = "gradedassessments")
    private Integer gradedassessments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Integer getReadyassessments() {
        return readyassessments;
    }

    public void setReadyassessments(Integer readyassessments) {
        this.readyassessments = readyassessments;
    }

    public Integer getGradedassessments() {
        return gradedassessments;
    }

    public void setGradedassessments(Integer gradedassessments) {
        this.gradedassessments = gradedassessments;
    }

}