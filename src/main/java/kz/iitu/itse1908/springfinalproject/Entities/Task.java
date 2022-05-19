package kz.iitu.itse1908.springfinalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
@JsonIgnoreProperties("version")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "graderid", nullable = false)
    private User graderid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "testid")
    private Test testid;

    @Column(name = "tasktype", nullable = false)
    private String tasktype;

    @Column(name = "taskDescription", nullable = false)
    private String taskDescription;

    @OneToMany(mappedBy = "taskid", fetch = FetchType.EAGER)
    @OrderBy("id")
    private Set<TaskGroup> taskGroups = new LinkedHashSet<>();

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

    public Integer getGraderid() {
        return graderid.getId();
    }

    public void setGraderid(User graderid) {
        this.graderid = graderid;
    }

    public Test getTestid() {
        return testid;
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
    }

    public Set<TaskGroup> getTaskGroups() {
        return taskGroups;
    }

    public void setTaskGroups(Set<TaskGroup> taskGroups) {
        this.taskGroups = taskGroups;
    }


    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}