package kz.iitu.itse1908.springfinalproject.Entities;

import javax.persistence.*;

@Entity
@Table(name = "task_groups")
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
    private Task taskid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Group getGroupid() {
        return groupid;
    }

    public void setGroupid(Group groupid) {
        this.groupid = groupid;
    }

    public Task getTaskid() {
        return taskid;
    }

    public void setTaskid(Task taskid) {
        this.taskid = taskid;
    }

}