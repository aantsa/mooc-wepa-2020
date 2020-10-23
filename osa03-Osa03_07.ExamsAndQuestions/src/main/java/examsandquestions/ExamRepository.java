package examsandquestions;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author anton
 */
public interface ExamRepository extends JpaRepository<Exam, Long>{
    
}