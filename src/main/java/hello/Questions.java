package hello;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Questions {
    private int    uid;
    private String question;
    private String correctAnswer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int    marks;

    public Questions(){}

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "uid" , unique = true)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @NotNull
    @Column(name = "question" ,nullable = false)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Column(name = "correctanswer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Column(name = "option1")
    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    @Column(name = "option2")
    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    @Column(name = "option3")
    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    @Column(name = "option4")
    public String getOption4() {
        return option4;
    }


    public void setOption4(String option4) {
        this.option4 = option4;
    }

    @Column(name = "marks")
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
