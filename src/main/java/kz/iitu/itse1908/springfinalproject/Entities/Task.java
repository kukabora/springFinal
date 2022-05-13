package kz.iitu.itse1908.springfinalproject.Entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "graderid", nullable = false)
    private User graderid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testid")
    private Test testid;

    @Column(name = "tasktype", nullable = false)
    private String tasktype;

    @Column(name = "taskDescription", nullable = false)
    private String taskDescription;

    @OneToMany(mappedBy = "taskid")
    private Set<TaskGroup> taskGroups = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getGraderid() {
        return graderid;
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