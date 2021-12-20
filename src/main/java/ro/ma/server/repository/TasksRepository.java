package ro.ma.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.ma.server.model.Task;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Task, Integer> {

    @Query("from Task t inner join UsersTasks ut on t.taskId = ut.taskId where ut.userId = :userId")
    List<Task> findByUserId(int userId);
}