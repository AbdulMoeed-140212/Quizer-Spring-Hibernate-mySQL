package Quizer.springBoot.service.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/*
* A Question has
* A statement
* An Ansewr
* 4 Options
* and
* Marks
* options can be null on bases of type of question
* */

@Entity
@Table(name = "question")
public class question{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qid;
    private String statement;
    private String answer;
    private int marks;
    private String option1;
    private String option2;
    private String option3;
    private String option4;


    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
