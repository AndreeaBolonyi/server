package ro.ma.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ma.server.model.User;
import ro.ma.server.repository.UsersRepository;

import java.util.Optional;

@RestController
@RequestMapping(value = "to-do-list/users")
public class UsersController {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @RequestMapping(value = "/github-username/{gitHubUsername}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByGitHubUsername(@PathVariable String gitHubUsername) {
        User userFound = usersRepository.getByGitHubUsername(gitHubUsername);

        if(userFound != null) {
            System.out.println("Found user with id: " + userFound.getUserId() + " for GitHub username: " + gitHubUsername);
            return new ResponseEntity<>(userFound, HttpStatus.OK);
        }

        System.out.println("Cannot found user for GitHub username: " + gitHubUsername);
        return new ResponseEntity<>("Cannot found user with GitHub username: " + gitHubUsername, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> getUserByEmailAndPassword(@RequestBody User user) {
        User userFound = usersRepository.getByEmailAndAndPassword(user.getEmail(), user.getPassword());

        if(userFound != null) {
            System.out.println("Found user with id: " + userFound.getUserId() + " for email: " + user.getEmail());
            return new ResponseEntity<>(userFound, HttpStatus.OK);
        }

        System.out.println("Cannot found user for email: " + user.getEmail());
        return new ResponseEntity<>("Cannot found user with email: " + user.getEmail(), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable int userId) {
        Optional<User> userFound = usersRepository.findById(userId);

        if(userFound.isPresent()) {
            System.out.println("Found user with id: " + userFound.get().getUserId());
            return new ResponseEntity<>(userFound, HttpStatus.OK);
        }

        System.out.println("Cannot found user for id: " + userId);
        return new ResponseEntity<>("Cannot found user with this id: " + userId, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/new-user", method = RequestMethod.POST)
    public ResponseEntity<Integer> addUser(@RequestBody User user) {
        user = usersRepository.save(user);

        System.out.println("Added user: " + user);
        return new ResponseEntity<>(user.getUserId(), HttpStatus.OK);
    }
}