package ua.edu.op.webapplication.feedback;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FeedbackRepository extends JpaRepository <Feedback,Long> {
}
