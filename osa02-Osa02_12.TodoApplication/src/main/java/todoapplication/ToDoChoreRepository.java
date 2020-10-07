package todoapplication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoChoreRepository extends JpaRepository<ToDoChore, Long>{
    
}