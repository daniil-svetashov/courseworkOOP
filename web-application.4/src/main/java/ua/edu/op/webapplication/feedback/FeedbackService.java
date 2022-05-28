package ua.edu.op.webapplication.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class FeedbackService {

    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void addFeedback (Feedback feedback)
    {
        Date date = new Date();
        feedback.setDate(date);
        feedbackRepository.saveAndFlush(feedback);
    }

}
