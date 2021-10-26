
package co.usa.edu.spring.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Andre
 */

@Entity
@Table(name="score")
public class Score implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable = false)
    private Integer idScore;
    
    @Column
    private Integer score;
    @Column
    private String message;
    
    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;
    
    public Score() {
        super();
    }

    public Score(Integer idScore, Integer score, String message, Reservation reservation) {
        this.idScore = idScore;
        this.score = score;
        this.message = message;
        this.reservation = reservation;
    }

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdScore(Integer idScore) {
        this.idScore = idScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Score{" + "idScore=" + idScore + ", score=" + score + ", message=" + message + ", reservation=" + reservation + '}';
    }
    
}
