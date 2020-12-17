package by.kremen.theatre.repository;

import by.kremen.theatre.model.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    Review findByTitle(String title);
    List<Review> findAllByTitle(String title);
}
