package ro.ma.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ma.server.model.UserTask;
import ro.ma.server.repository.UsersTasksRepository;

import java.util.List;

@RestController
@RequestMapping(value = "to-do-list/users-tasks")
public class UsersTasksController {

    private UsersTasksRepository usersTasksRepository;

    @Autowired
    public void setUsersTasksRepository(UsersTasksRepository usersTasksRepository) {
        this.usersTasksRepository = usersTasksRepository;
    }

    @RequestMapping(value = "/users-ids-for-task-id/{taskId}", method = RequestMethod.GET)
    public ResponseEntity<List<Integer>> getAllUsersIdForTaskId(@PathVariable Integer taskId) {
        List<Integer> allUsersIds = usersTasksRepository.getAllUsersIdForTaskId(taskId);

        System.out.println("Found " + allUsersIds.size() + " user ids for task id: " + taskId);
        return new ResponseEntity<>(allUsersIds, HttpStatus.OK);
    }

    @RequestMapping(value = "/new-user-task", method = RequestMethod.POST)
    public ResponseEntity<?> addUserTask(@RequestBody UserTask userTask) {
        usersTasksRepository.save(userTask);

        System.out.println("Added user task: " + userTask);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
