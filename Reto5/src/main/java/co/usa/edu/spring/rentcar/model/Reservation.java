
package co.usa.edu.spring.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Andre
 */

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Integer idReservation;
    
    
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "devolutionDate")
    private Date devolutionDate;
    @Column
    private String status;
    
    
    @ManyToOne
    @JoinColumn(name = "idReservations")
    @JsonIgnoreProperties("reservations")
    private Car car;
    
    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client; 
    
    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
    
    public Reservation() {
        super();
    }

    public Reservation(Integer idReservation, Date startDate, Date devolutionDate, Car car, Client client, Score score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.car = car;
        this.client = client;
        this.score = score;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", startDate=" + startDate + ", devolutionDate=" + devolutionDate + ", status=" + status + ", car=" + car + ", client=" + client + ", score=" + score + '}';
    }

}
