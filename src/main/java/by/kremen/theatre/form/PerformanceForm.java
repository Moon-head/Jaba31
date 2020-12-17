package by.kremen.theatre.form;

import by.kremen.theatre.model.Actor;
import by.kremen.theatre.model.Theater;
import by.kremen.theatre.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class PerformanceForm {

    @Autowired
    private TheaterRepository theaterRepository;

    private Integer id;

    private String title;

    public int theater_id;

    private Date date;

    private Time time;

    List<Actor> actors;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTheater_id(int id) {
        this.theater_id = id;
    }

    public void setDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd H:mm:ss", Locale.ENGLISH);

        this.date = formatter.parse(date);
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Theater getTheater() {
        return theaterRepository.findById(this.theater_id);
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public List<Actor> getActors() {
        return actors;
    }
}
