package hello;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name = "hellolog")
public class HelloLog {
    private int uid;
    private String name;
    private Date timestamp;
    // no-arg Constructor
    public HelloLog(){}
    public HelloLog(String name){
        this.name = name;
        this.timestamp  = new Date();
    }
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    @Column(name = "timestamp" ,nullable = false)
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
