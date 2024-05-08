package in.uniconnects.repository;

import in.uniconnects.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    public User findByUsername(String username);

}
