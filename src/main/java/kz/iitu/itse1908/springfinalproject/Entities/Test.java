package kz.iitu.itse1908.springfinalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tests")
@JsonIgnoreProperties({"testquestions", "assesments", "tasks"})
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "creatorid", nullable = false)
    private User creatorid;

    @OneToMany(mappedBy = "testid")
    private Set<Task> tasks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "testid")
    private Set<Assesment> assesments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "testid")
    private Set<Testquestion> testquestions = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatorid() {
        return creatorid.getId();
    }

    public void setCreatorid(User creatorid) {
        this.creatorid = creatorid;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Assesment> getAssesments() {
        return assesments;
    }

    public void setAssesments(Set<Assesment> assesments) {
        this.assesments = assesments;
    }

    public Set<Testquestion> getTestquestions() {
        return testquestions;
    }

    public void setTestquestions(Set<Testquestion> testquestions) {
        this.testquestions = testquestions;
    }

}