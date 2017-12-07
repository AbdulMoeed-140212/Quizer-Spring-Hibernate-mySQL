package Quizer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
@Inheritance(strategy = InheritanceType.JOINED)
public class Questions {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int    uid;
    @Column
    private String question;
    @Column
    private String correctAnswer;
    @Column
    private int    marks;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
