package mx.tc.project.CarRentalSystem.repositories;

import mx.tc.project.CarRentalSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {


    User findUserByName(String name);

}
