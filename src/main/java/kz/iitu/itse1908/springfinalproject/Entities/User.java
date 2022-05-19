package kz.iitu.itse1908.springfinalproject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"tasks", "tests", "assesments", "createdNotifications", "notifications", "usersgradedetails", "version"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "fname", nullable = false, length = 50)
    private String fname;

    @Column(name = "lname", nullable = false, length = 50)
    private String lname;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roleid", nullable = false)
    @JsonIgnore
    private Role roleid;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "groupid", nullable = false)
    @JsonIgnore
    private Group groupid;

    @OneToMany(mappedBy = "graderid")
    private Set<Task> tasks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "creatorid")
    private Set<Test> tests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "assessorid")
    private Set<Assesment> assesments = new LinkedHashSet<>();

    @OneToOne(mappedBy = "userid")
    private Usersgradedetail usersgradedetails;

    @OneToMany(mappedBy = "creatorid")
    private Set<Notification> createdNotifications = new LinkedHashSet<>();

    @OneToMany(mappedBy = "recieverid")
    @OrderBy("id")
    private Set<Notification> notifications = new LinkedHashSet<>();

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleid() {
        return roleid;
    }

    public void setRoleid(Role roleid) {
        this.roleid = roleid;
    }

    public Group getGroupid() {
        return groupid;
    }

    public void setGroupid(Group groupid) {
        this.groupid = groupid;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    public Set<Assesment> getAssesments() {
        return assesments;
    }

    public void setAssesments(Set<Assesment> assesments) {
        this.assesments = assesments;
    }

    public Usersgradedetail getUsersgradedetails() {
        return usersgradedetails;
    }

    public void setUsersgradedetails(Usersgradedetail usersgradedetails) {
        this.usersgradedetails = usersgradedetails;
    }

    public Set<Notification> getCreatedNotifications() {
        return createdNotifications;
    }

    public void setCreatedNotifications(Set<Notification> createdNotifications) {
        this.createdNotifications = createdNotifications;
    }

    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

}