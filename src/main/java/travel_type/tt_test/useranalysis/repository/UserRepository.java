package travel_type.tt_test.useranalysis.repository;

import travel_type.tt_test.useranalysis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
