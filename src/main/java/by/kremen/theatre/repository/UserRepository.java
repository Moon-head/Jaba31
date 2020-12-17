package by.kremen.theatre.repository;


import by.kremen.theatre.model.Performance;
import by.kremen.theatre.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(int id);
    User findByUsername(String username);

}
