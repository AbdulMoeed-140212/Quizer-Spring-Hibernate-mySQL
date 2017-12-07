package Quizer.model.type;

import Quizer.model.Questions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class truefalse extends Questions{
    @Column
    private String trueyes = "True";
    @Column
    private String fasleno = "False";

    public String getTrueyes() {
        return trueyes;
    }

    public void setTrueyes(String trueyes) {
        this.trueyes = trueyes;
    }

    public String getFasleno() {
        return fasleno;
    }

    public void setFasleno(String fasleno) {
        this.fasleno = fasleno;
    }
}
