package ro.ma.server.model;

import java.io.Serializable;

public class UserTaskId implements Serializable {
    private Integer userId;
    private Integer taskId;

    public UserTaskId() {}

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
}
