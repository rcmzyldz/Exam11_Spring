package be.intec.exam11.repositories;

import be.intec.exam11.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer > {
}
