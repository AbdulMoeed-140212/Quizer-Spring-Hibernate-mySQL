package Quizer.springBoot.service.model;


import javax.persistence.*;


//Parent Class User
// ID (primary Ky)
// Name
// Extnded By Student and Teacher
@Entity
@Table(name = "user")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
