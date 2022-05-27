package ua.edu.op.webapplication.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackService {

    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void addFeedback (Feedback feedback)
    {
        feedbackRepository.saveAndFlush(feedback);
    }

}
