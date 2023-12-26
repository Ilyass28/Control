package ma.xproce.computerservice.repositories;

import ma.xproce.computerservice.entities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
