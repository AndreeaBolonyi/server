package ro.ma.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_tasks")
@IdClass(UserTaskId.class)
public class UserTask implements Serializable {
    private int userId;
    private int taskId;

    public UserTask() {}

    @Id
    @Column(name = "userid")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "taskid")
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "UserTask{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                '}';
    }
}
