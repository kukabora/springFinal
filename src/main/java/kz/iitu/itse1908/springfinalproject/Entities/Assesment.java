package kz.iitu.itse1908.springfinalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "assesments")
@JsonIgnoreProperties("VERSION")
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
    @OrderBy("id")
    private User assessorid;

    @Column(name = "\"assessmentPath\"")
    private String assessmentPath;

    @Version
    @Column(name = "version")
    private long version;

    @Transient
    public boolean isNew() {
        return id == null;
    }

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