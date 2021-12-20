package ro.ma.server.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table( name = "tasks" )
public class Task {
    private int taskId;
    private String title;
    private LocalDate deadline;
    private LocalDate created;
    private int priority;
    private List<User> users;

    public Task() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid", nullable = false, updatable = false, unique = true)
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "deadline")
    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Column(name = "created")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Column(name = "priority")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @ManyToMany
    @JoinTable(
            name = "users_tasks",
            joinColumns = @JoinColumn(name = "taskid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", deadline=" + deadline +
                ", created=" + created +
                ", priority=" + priority +
                ", users=" + users +
                '}';
    }
}