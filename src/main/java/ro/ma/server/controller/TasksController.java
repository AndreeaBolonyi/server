package ro.ma.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ma.server.model.Task;
import ro.ma.server.repository.TasksRepository;

import java.util.List;

@RestController
@RequestMapping(value = "to-do-list/tasks")
public class TasksController {

    private TasksRepository tasksRepository;

    @Autowired
    public void setTasksRepository(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @RequestMapping(value = "/tasks-for-user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getAllByUserId(@PathVariable int userId) {
        List<Task> tasks = tasksRepository.findByUserId(userId);

        System.out.println("Found " + tasks.size() + " tasks for user id: " + userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @RequestMapping(value = "/new-task", method = RequestMethod.POST)
    public ResponseEntity<String> addTask(@RequestBody Task task) {
        task = tasksRepository.save(task);

        System.out.println("Added task: " + task);
        return new ResponseEntity<>("Task added: " + task, HttpStatus.OK);
    }

    @RequestMapping(value = "/update-task", method = RequestMethod.PUT)
    public ResponseEntity<String> updateTask(@RequestBody Task task) {
        task = tasksRepository.save(task);

        System.out.println("Updated task: " + task);
        return new ResponseEntity<>("Task updated: " + task, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete-task/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTask(@PathVariable int taskId) {
        Task taskToDelete = new Task(); taskToDelete.setTaskId(taskId);
        tasksRepository.delete(taskToDelete);

        System.out.println("Deleted task id: " + taskId);
        return new ResponseEntity<>("Task(id) deleted: " + taskId, HttpStatus.OK);
    }
}