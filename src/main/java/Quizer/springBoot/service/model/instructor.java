package Quizer.springBoot.service.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/*
* Instructer Extends User
* Instructor can have many quizes
* */
@Entity
@Table(name= "instructor")
public class instructor extends user{
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<quiz> quizes;

    public List<quiz> getQuizes() {
        return quizes;
    }

    public void setQuizes(List<quiz> quizes) {
        this.quizes = quizes;
    }
}
