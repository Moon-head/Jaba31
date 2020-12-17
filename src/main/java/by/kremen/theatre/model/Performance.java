package by.kremen.theatre.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="performances")
public class Performance {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(name="title")
    private String title;

    @NotNull
    @ManyToOne
    private Theater theater;

    @NotBlank
    @Column(name="date")
    private Date date;

    @NotBlank
    @Column(name="time")
    private Time time;

    @NotEmpty
    @ManyToMany
    @JoinTable(name="Performance_actor", joinColumns = @JoinColumn(name="performance_id"),inverseJoinColumns = @JoinColumn(name="actor_id"))
    List<Actor> actors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
