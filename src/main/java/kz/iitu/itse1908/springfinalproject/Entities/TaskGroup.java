package kz.iitu.itse1908.springfinalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "task_groups")
@JsonIgnoreProperties("version")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "groupid", nullable = false)
    private Group groupid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "taskid", nullable = false)
    @OrderBy("id")
    private Task taskid;

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

    public Integer getGroupid() {
        return groupid.getId();
    }

    public void setGroupid(Group groupid) {
        this.groupid = groupid;
    }

    public Integer getTaskid() {
        return taskid.getId();
    }

    public void setTaskid(Task taskid) {
        this.taskid = taskid;
    }

}