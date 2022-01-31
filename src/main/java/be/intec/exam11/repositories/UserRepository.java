package be.intec.exam11.repositories;


import be.intec.exam11.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer > {
}
