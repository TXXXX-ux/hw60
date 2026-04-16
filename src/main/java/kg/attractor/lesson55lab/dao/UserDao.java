package kg.attractor.lesson55lab.dao;

import kg.attractor.lesson55lab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}