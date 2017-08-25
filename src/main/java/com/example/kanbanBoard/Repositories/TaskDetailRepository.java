package com.example.kanbanBoard.Repositories;

import com.example.kanbanBoard.Domains.TaskDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDetailRepository extends JpaRepository<TaskDetails, Long> {
}
