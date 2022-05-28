package ua.edu.op.webapplication.feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.op.webapplication.user.User;

public interface FeedbackRepository extends JpaRepository <Feedback,Long> {
}
