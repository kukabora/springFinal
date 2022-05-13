package kz.iitu.itse1908.springfinalproject.Entities;

import javax.persistence.*;

@Entity
@Table(name = "assesments")
public class Assesment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "testid", nullable = false)
    private Test testid;

    @Column(name = "testreult")
    private Integer testreult;

    @Column(name = "assesmentgrade", nullable = false)
    private Integer assesmentgrade;

    @Column(name = "graded")
    private Boolean graded;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assessorid", nullable = false)
    private User assessorid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Test getTestid() {
        return testid;
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }

    public Integer getTestreult() {
        return testreult;
    }

    public void setTestreult(Integer testreult) {
        this.testreult = testreult;
    }

    public Integer getAssesmentgrade() {
        return assesmentgrade;
    }

    public void setAssesmentgrade(Integer assesmentgrade) {
        this.assesmentgrade = assesmentgrade;
    }

    public Boolean getGraded() {
        return graded;
    }

    public void setGraded(Boolean graded) {
        this.graded = graded;
    }

    public User getAssessorid() {
        return assessorid;
    }

    public void setAssessorid(User assessorid) {
        this.assessorid = assessorid;
    }

}