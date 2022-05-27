package ua.edu.op.webapplication.feedback;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "feedback")//Если name = "user" , то выдает ошибку
@Data
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long feedbackId;

    @Size(min=2, max=255, message="feedback should be from 2 to 255 characters")
    private String userFeedback;


    //реализовать текущую дату
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date;


    public Feedback(long feedbackId, String feedback) {
        this.feedbackId = feedbackId;
        this.userFeedback = feedback;
    }

    public Feedback() {

    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackId=" + feedbackId +
                ", feedback='" + userFeedback + '\'' +
                '}';
    }
}
