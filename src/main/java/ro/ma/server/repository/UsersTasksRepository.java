package ro.ma.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ma.server.model.UserTask;

import java.util.List;

@Repository
public interface UsersTasksRepository extends JpaRepository<UserTask, Integer> {

    @Query("select userId from UserTask where taskId = :taskId")
    List<Integer> getAllUsersIdForTaskId(int taskId);
}