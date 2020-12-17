package by.kremen.theatre.repository;

import by.kremen.theatre.model.Performance;
import by.kremen.theatre.model.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Repository
public interface PerformanceRepository extends CrudRepository<Performance, Integer> {
    Performance findById(int id);
    List<Performance> findById(long id);
    Performance findByTitle(String title);
    List<Performance> findByTheater(Theater theater);
    List<Performance> findByDate(Date date);
    List<Performance> findByTime(Time time);
}

