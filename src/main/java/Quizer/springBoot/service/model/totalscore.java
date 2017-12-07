package Quizer.springBoot.service.model;

import javax.persistence.*;
import java.sql.Date;
//--------------------------------------------//
// Score Card object
// A score card for each attempted Quiz
// Each Student can have many score cards
// Attributes:
// total ( obtained marks)
// outof ( maximum marks)
// time  ( time at which record is saved)
//---------------------------------------------//
@Entity
@Table(name= "results")
public class totalscore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private int total;
    private int outof;
    private Date time;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getOutof() {
        return outof;
    }

    public void setOutof(int outof) {
        this.outof = outof;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
