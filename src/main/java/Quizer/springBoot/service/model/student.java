package Quizer.springBoot.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


//------------------//
//student
//can have many result cards
//------------------//
@Entity
@Table(name= "student")
public class student extends user {
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<totalscore> scores;

    public List<totalscore> getScores() {
        return scores;
    }

    public void setScores(List<totalscore> scores) {
        this.scores = scores;
    }
}
