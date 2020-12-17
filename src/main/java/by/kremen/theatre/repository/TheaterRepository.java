package by.kremen.theatre.repository;

import by.kremen.theatre.model.Theater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends CrudRepository<Theater, Integer> {
    Theater findByName(String name);
    List<Theater> findAllByName(String name);
}
