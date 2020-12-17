package by.kremen.theatre.repository;

import by.kremen.theatre.model.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Integer> {
    Actor findByName(String name);
    List<Actor> findAllByName(String name);
    List<Actor> findAll();
}
