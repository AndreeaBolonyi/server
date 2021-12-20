package ro.ma.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ma.server.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    @Query("from User where gitHubUsername = :gitHubUsername")
    User getByGitHubUsername(String gitHubUsername);

    @Query("from User where email = :email and password = :password")
    User getByEmailAndAndPassword(String email, String password);
}