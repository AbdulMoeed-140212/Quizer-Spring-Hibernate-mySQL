package Quizer.springBoot.service.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

// Quiz
/*
*  one instructor can have many quiz
*  A quiz can have many questions
*
* */
@Entity
@Table(name = "quiz")
public class quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quizid;

    @OneToMany(cascade = CascadeType.PERSIST)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<question> questions;

    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public List<question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<question> questions) {
        this.questions = questions;
    }
}
