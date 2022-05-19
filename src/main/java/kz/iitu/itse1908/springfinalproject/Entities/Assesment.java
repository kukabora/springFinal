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
    @JoinColumn(name = "taskid", nullable = false)
    private Task taskid;

    @Column(name = "testresult")
    private Integer testresult;

    @Column(name = "assesmentgrade", nullable = false)
    private Double assesmentgrade;

    @Column(name = "graded")
    private Boolean graded;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assessorid", nullable = false)
    private User assessorid;

    @Lob
    @Column(name = "\"assessmentPath\"")
    private String assessmentPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Task getTaskid() {
        return taskid;
    }

    public void setTaskid(Task taskid) {
        this.taskid = taskid;
    }

    public Integer getTestresult() {
        return testresult;
    }

    public void setTestresult(Integer testresult) {
        this.testresult = testresult;
    }

    public Double getAssesmentgrade() {
        return assesmentgrade;
    }

    public void setAssesmentgrade(Double assesmentgrade) {
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

    public String getAssessmentPath() {
        return assessmentPath;
    }

    public void setAssessmentPath(String assessmentPath) {
        this.assessmentPath = assessmentPath;
    }

}